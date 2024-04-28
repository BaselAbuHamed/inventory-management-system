package edu.comp4382.inventorymanagementsystem.service.impl;

import edu.comp4382.inventorymanagementsystem.dto.OrderDetailsDto;
import edu.comp4382.inventorymanagementsystem.entity.OrderDetails;
import edu.comp4382.inventorymanagementsystem.exception.ResourceNotFoundException;
import edu.comp4382.inventorymanagementsystem.mapper.OrderDetailsMapper;
import edu.comp4382.inventorymanagementsystem.repository.OrderDetailsRepository;
import edu.comp4382.inventorymanagementsystem.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {


    OrderDetailsRepository orderDetailsRepository;
    OrderDetailsMapper orderDetailsMapper;

    @Autowired
    public OrderDetailsServiceImpl(OrderDetailsRepository orderDetailsRepository, OrderDetailsMapper orderDetailsMapper) {
        this.orderDetailsRepository = orderDetailsRepository;
        this.orderDetailsMapper = orderDetailsMapper;
    }

    @Override
    public OrderDetailsDto createOrderDetails(OrderDetailsDto orderDetailsDto) {
        OrderDetails orderDetails = orderDetailsMapper.mapDtoToOrderDetails(orderDetailsDto);
        OrderDetails savedOrderDetails = orderDetailsRepository.save(orderDetails);
        return orderDetailsMapper.mapOrderDetailsToDto(savedOrderDetails);
    }

    @Override
    public OrderDetailsDto getOrderDetailsById(Long id) {
        OrderDetails orderDetails = orderDetailsRepository.findById(id).
                orElseThrow(() ->
                        new ResourceNotFoundException //edited
                                ("Order Details not found with given id : " + id));
        return orderDetailsMapper.mapOrderDetailsToDto(orderDetails);
    }

    @Override
    public List<OrderDetailsDto> getAllOrderDetails() {
        List<OrderDetails> orderDetails = orderDetailsRepository.findAll();
        List<OrderDetailsDto> orderDetailsDto = new ArrayList<>();
        for (OrderDetails orderDetail : orderDetails) {
            orderDetailsDto.add(orderDetailsMapper.mapOrderDetailsToDto(orderDetail));
        }
        return orderDetailsDto;
    }

    @Override
    public OrderDetailsDto updateOrderDetails(Long id, OrderDetailsDto orderDetailsDto) {

        OrderDetails orderDetails = orderDetailsRepository.findById(id).
                orElseThrow(() ->
                        new ResourceNotFoundException //edited
                                ("Order Details not found with given id : " + id));

        orderDetails.setPrice(orderDetailsDto.getPrice());
        orderDetails.setQuantity(orderDetailsDto.getQuantity());
        OrderDetails updatedOrderDetails = orderDetailsRepository.save(orderDetails);

        return orderDetailsMapper.mapOrderDetailsToDto(updatedOrderDetails);
    }

    @Override
    public OrderDetailsDto patchOrderDetails(Long id, OrderDetailsDto orderDetailsDto) {
        OrderDetails orderDetails = orderDetailsRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException //edited
                                ("Order Details not found with given id : " + id));

        if (!Double.isNaN(orderDetailsDto.getPrice())) {
            orderDetails.setPrice(orderDetailsDto.getPrice());
        }
        Integer quantity = orderDetailsDto.getQuantity();
        if (quantity != null) {
            orderDetails.setQuantity(quantity);
        }
        OrderDetails updatedOrderDetails = orderDetailsRepository.save(orderDetails);

        return orderDetailsMapper.mapOrderDetailsToDto(updatedOrderDetails);
    }


    @Override
    public void deleteOrderDetails(Long id) {

        //updated
        if (!orderDetailsRepository.existsById(id)) {
            throw new ResourceNotFoundException("Order Details not found with given id : " + id);
        }

        try {
            orderDetailsRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Order Details not found with given id : " + id);
        }
    }
}
