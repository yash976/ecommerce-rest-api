package com.ecommerce.api.service;

import com.ecommerce.api.model.CartItem;
import com.ecommerce.api.model.Order;
import com.ecommerce.api.model.OrderItem;
import com.ecommerce.api.repository.CartItemRepository;
import com.ecommerce.api.repository.OrderItemRepository;
import com.ecommerce.api.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final CartItemRepository cartItemRepository;

    public Order placeOrder(Long userId) {

        List<CartItem> cartItems = cartItemRepository.findByUserId(userId);

        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cart is empty!");
        }

        double totalAmount = cartItems.stream()
                .mapToDouble(item -> item.getQuantity() * 100)  // fixed product price for simplicity
                .sum();

        Order order = Order.builder()
                .userId(userId)
                .orderDate(LocalDateTime.now())
                .totalAmount(totalAmount)
                .build();

        order = orderRepository.save(order);

        List<OrderItem> orderItems = cartItems.stream()
                .map(item -> OrderItem.builder()
                        .orderId(order.getId())
                        .productId(item.getProductId())
                        .quantity(item.getQuantity())
                        .price(100) // fixed price for simplicity
                        .build())
                .collect(Collectors.toList());

        orderItemRepository.saveAll(orderItems);

        cartItemRepository.deleteByUserId(userId);

        order.setItems(orderItems);

        return order;
    }

    public List<Order> getUserOrders(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
