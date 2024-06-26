package edu.comp4382.inventorymanagementsystem.mapper;

import edu.comp4382.inventorymanagementsystem.dto.OrderDetailsDto;
import edu.comp4382.inventorymanagementsystem.entity.Order;
import edu.comp4382.inventorymanagementsystem.entity.OrderDetails;
import edu.comp4382.inventorymanagementsystem.entity.Product;
import edu.comp4382.inventorymanagementsystem.repository.OrderRepository;
import edu.comp4382.inventorymanagementsystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class OrderDetailsMapper {


    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Autowired
    public OrderDetailsMapper(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public OrderDetailsDto mapOrderDetailsToDto(OrderDetails orderDetails) {

        return new OrderDetailsDto(orderDetails.getOrderDetailsId(),
                orderDetails.getOrderId().getOrderId(),
                orderDetails.getQuantity(),
                orderDetails.getPrice(),
                orderDetails.getProductId().getProductId());
    }

    public OrderDetails mapDtoToOrderDetails(OrderDetailsDto orderDetailsDto) {

        OrderDetails orderDetails = new OrderDetails();

        Product product = productRepository.findById(orderDetailsDto.getProductId()).
                orElseThrow(() -> new RuntimeException(
                        "Product not found with given id : " + orderDetailsDto.getProductId()));

        Order order = orderRepository.findById(orderDetailsDto.getOrderId()).
                orElseThrow(() -> new RuntimeException(
                        "Order not found with given id : " + orderDetailsDto.getOrderId()));

        orderDetails.setOrderDetailsId(orderDetailsDto.getOrderDetailsId());
        orderDetails.setOrderId(order);
        orderDetails.setQuantity(orderDetailsDto.getQuantity());
        orderDetails.setPrice(orderDetailsDto.getPrice());
        orderDetails.setProductId(product);
        return orderDetails;
    }
}
