package edu.comp4382.inventorymanagementsystem.service.impl;

import edu.comp4382.inventorymanagementsystem.dto.OrderDto;
import edu.comp4382.inventorymanagementsystem.entity.Order;
import edu.comp4382.inventorymanagementsystem.mapper.OrderMapper;
import edu.comp4382.inventorymanagementsystem.repository.OrderRepository;
import edu.comp4382.inventorymanagementsystem.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository ;
    OrderMapper orderMapper = new OrderMapper();

    @Override
    public OrderDto createOrder(OrderDto orderDto) {

        Order order = orderMapper.mapToOrder(orderDto);
        Order savedOrder = orderRepository.save(order);
        return orderMapper.mapToOrderDto(savedOrder);
    }

    @Override
    public OrderDto getOrderById(Long orderId) {

        Order order = orderRepository.findById(orderId).
                orElseThrow(() -> new RuntimeException("Order not found with given id : "+orderId));

        return orderMapper.mapToOrderDto(order);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDto> orderDto =new ArrayList<>();
        for (Order order : orders) {
            orderDto.add(orderMapper.mapToOrderDto(order));
        }
        return orderDto;
    }

    @Override
    public void deleteOrder(Long orderId) {

    }
}
