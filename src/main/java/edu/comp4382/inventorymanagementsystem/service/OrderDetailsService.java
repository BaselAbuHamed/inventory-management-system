package edu.comp4382.inventorymanagementsystem.service;

import edu.comp4382.inventorymanagementsystem.dto.OrderDetailsDto;

import java.util.List;

public interface OrderDetailsService {

    OrderDetailsDto createOrderDetails(OrderDetailsDto orderDetailsDto);

    OrderDetailsDto getOrderDetailsById(Long id);

    List<OrderDetailsDto> getAllOrderDetails();

    OrderDetailsDto updateOrderDetails(Long id, OrderDetailsDto orderDetailsDto);

    OrderDetailsDto patchOrderDetails(Long id, OrderDetailsDto orderDetailsDto);

    void deleteOrderDetails(Long id);

}
