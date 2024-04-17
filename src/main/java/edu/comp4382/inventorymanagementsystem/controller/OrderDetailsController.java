package edu.comp4382.inventorymanagementsystem.controller;


import edu.comp4382.inventorymanagementsystem.dto.OrderDetailsDto;
import edu.comp4382.inventorymanagementsystem.service.OrderDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/order-details")
public class OrderDetailsController {

    private OrderDetailsService orderDetailsService;

    //Build Add OrderDetails Rest API
    @PostMapping
    public ResponseEntity<OrderDetailsDto> createOrderDetails(@RequestBody OrderDetailsDto orderDetailsDto) {
        OrderDetailsDto savedOrderDetails = orderDetailsService.createOrderDetails(orderDetailsDto);
        return new ResponseEntity<>(savedOrderDetails, HttpStatus.CREATED);
    }

    //Build Get OrderDetails By Id Rest API
    @GetMapping("/{id}")
    public ResponseEntity<OrderDetailsDto> getOrderDetailsById(@PathVariable Long id) {
        OrderDetailsDto orderDetails = orderDetailsService.getOrderDetailsById(id);
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }

    //Build Get All OrderDetails Rest API
    @GetMapping
    public ResponseEntity<List<OrderDetailsDto>> getAllOrderDetails() {
        List<OrderDetailsDto> orderDetails = orderDetailsService.getAllOrderDetails();
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }

    //Build Update OrderDetails Rest API
    @PutMapping("/{id}")
    public ResponseEntity<OrderDetailsDto> updateOrderDetails(@PathVariable Long id, @RequestBody OrderDetailsDto orderDetailsDto) {
        OrderDetailsDto updatedOrderDetails = orderDetailsService.updateOrderDetails(id, orderDetailsDto);
        return new ResponseEntity<>(updatedOrderDetails, HttpStatus.OK);
    }

    //Build Patch OrderDetails Rest API
    @PatchMapping("/{id}")
    public ResponseEntity<OrderDetailsDto> patchOrderDetails(@PathVariable Long id, @RequestBody OrderDetailsDto orderDetailsDto) {
        OrderDetailsDto updatedOrderDetails = orderDetailsService.patchOrderDetails(id, orderDetailsDto);
        return new ResponseEntity<>(updatedOrderDetails, HttpStatus.OK);
    }

    //Build Delete OrderDetails Rest API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrderDetails(@PathVariable("id") Long id) {
        orderDetailsService.deleteOrderDetails(id);
        return ResponseEntity.ok("Order Details deleted successfully.");
    }

}
