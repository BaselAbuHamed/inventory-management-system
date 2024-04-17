package edu.comp4382.inventorymanagementsystem.service.impl;

import edu.comp4382.inventorymanagementsystem.dto.OrderDto;
import edu.comp4382.inventorymanagementsystem.entity.Order;
import edu.comp4382.inventorymanagementsystem.mapper.OrderMapper;
import edu.comp4382.inventorymanagementsystem.repository.OrderRepository;
import edu.comp4382.inventorymanagementsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;
    OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {

        Order order = orderMapper.mapToOrder(orderDto);
        Order savedOrder = orderRepository.save(order);
        return orderMapper.mapToOrderDto(savedOrder);
    }

    @Override
    public OrderDto getOrderById(Long orderId) {

        Order order = orderRepository.findById(orderId).
                orElseThrow(() -> new RuntimeException("Order not found with given id : " + orderId));

        return orderMapper.mapToOrderDto(order);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDto> orderDto = new ArrayList<>(List.of());
        for (Order order : orders) {
            orderDto.add(orderMapper.mapToOrderDto(order));
        }
        return orderDto;
    }

    @Override
    public OrderDto updateOrder(Long orderId, OrderDto orderDto) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with given id : " + orderId));

        order.setOrderDate(orderDto.getOrderDate());
        order.setTotalAmount(orderDto.getTotalAmount());
        Order updatedOrder = orderRepository.save(order);

        return orderMapper.mapToOrderDto(updatedOrder);
    }

    @Override
    public OrderDto patchOrder(Long orderId, OrderDto orderDto) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with given id : " + orderId));

        if (orderDto.getOrderDate() != null) {
            order.setOrderDate(orderDto.getOrderDate());
        }
        if (!Double.isNaN(orderDto.getTotalAmount())) {
            order.setTotalAmount(orderDto.getTotalAmount());
        }

        // Save the updated Order entity back to the repository
        Order updatedOrder = orderRepository.save(order);

        // Map the updated Order entity to an OrderDto and return it
        return orderMapper.mapToOrderDto(updatedOrder);
    }


    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
