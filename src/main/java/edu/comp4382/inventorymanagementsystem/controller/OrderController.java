package edu.comp4382.inventorymanagementsystem.controller;

import edu.comp4382.inventorymanagementsystem.dto.OrderDto;
import edu.comp4382.inventorymanagementsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //Build Add Order Rest API
    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
        OrderDto savedOrder = orderService.createOrder(orderDto);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    //Build Get Order By Id Rest API
    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long id) {
        OrderDto order = orderService.getOrderById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    //Build Get All Orders Rest API
    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    //Build Update Order Rest API
    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable("id") Long id, @RequestBody OrderDto orderDto) {
        OrderDto updatedOrder = orderService.updateOrder(id, orderDto);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    //Build Patch Order Rest API
    @PatchMapping("/{id}")
    public ResponseEntity<OrderDto> patchOrder(@PathVariable("id") Long id, @RequestBody OrderDto orderDto) {
        OrderDto updatedOrder = orderService.patchOrder(id, orderDto);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    //Build Delete Order Rest API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok("Order deleted successfully.");
    }
}
