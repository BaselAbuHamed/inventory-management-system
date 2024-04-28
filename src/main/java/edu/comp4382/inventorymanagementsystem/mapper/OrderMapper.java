package edu.comp4382.inventorymanagementsystem.mapper;

import edu.comp4382.inventorymanagementsystem.dto.OrderDto;
import edu.comp4382.inventorymanagementsystem.entity.Order;
import edu.comp4382.inventorymanagementsystem.entity.User;
import edu.comp4382.inventorymanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class OrderMapper {

    private final UserRepository userRepository;

    @Autowired
    public OrderMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public OrderDto mapToOrderDto(Order order) {
        return new OrderDto(order.getOrderId(),
                order.getUser().getUserId(),
                order.getOrderDate(),
                order.getTotalAmount()
        );
    }

    public Order mapToOrder(OrderDto orderDto) {
        Order order = new Order();
        User user = userRepository.findById(orderDto.getUserId()).
                orElseThrow(() -> new RuntimeException(
                        "User not found with given id : " + orderDto.getUserId()));
        order.setOrderDate(Timestamp.valueOf(LocalDateTime.now()));
        order.setUser(user);
        order.setTotalAmount(orderDto.getTotalAmount());
        return order;
    }
}
