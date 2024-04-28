package edu.comp4382.inventorymanagementsystem.controller;

import edu.comp4382.inventorymanagementsystem.dto.OrderDetailsDto;
import edu.comp4382.inventorymanagementsystem.service.OrderDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-details")
public class OrderDetailsController {

    private final OrderDetailsService orderDetailsService;

    @Autowired
    public OrderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }

    @PostMapping
    public ResponseEntity<OrderDetailsDto> createOrderDetails(@RequestBody OrderDetailsDto orderDetailsDto) {

            try {
                OrderDetailsDto savedOrderDetails = orderDetailsService.createOrderDetails(orderDetailsDto);
                return new ResponseEntity<>(savedOrderDetails, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetailsDto> getOrderDetailsById(@PathVariable Long id) {
        OrderDetailsDto orderDetails = orderDetailsService.getOrderDetailsById(id);
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OrderDetailsDto>> getAllOrderDetails() {
        List<OrderDetailsDto> orderDetails = orderDetailsService.getAllOrderDetails();
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDetailsDto> updateOrderDetails(@PathVariable Long id, @RequestBody OrderDetailsDto orderDetailsDto) {
        OrderDetailsDto updatedOrderDetails = orderDetailsService.updateOrderDetails(id, orderDetailsDto);
        return new ResponseEntity<>(updatedOrderDetails, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OrderDetailsDto> patchOrderDetails(@PathVariable Long id, @RequestBody OrderDetailsDto orderDetailsDto) {
        OrderDetailsDto updatedOrderDetails = orderDetailsService.patchOrderDetails(id, orderDetailsDto);
        return new ResponseEntity<>(updatedOrderDetails, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrderDetails(@PathVariable("id") Long id) {
        orderDetailsService.deleteOrderDetails(id);
        return ResponseEntity.ok("Order Details deleted successfully.");
    }
}
