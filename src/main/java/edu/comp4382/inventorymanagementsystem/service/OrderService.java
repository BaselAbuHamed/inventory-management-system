package edu.comp4382.inventorymanagementsystem.service;

import edu.comp4382.inventorymanagementsystem.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDto);

    OrderDto getOrderById(Long orderId);

    List<OrderDto> getAllOrders();

    OrderDto updateOrder(Long orderId, OrderDto orderDto);

    OrderDto patchOrder(Long orderId, OrderDto orderDto);

    void deleteOrder(Long orderId);
}
