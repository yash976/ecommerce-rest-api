package com.ecommerce.api.controller;

import com.ecommerce.api.model.Order;
import com.ecommerce.api.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/place")
    public Order placeOrder(@RequestParam Long userId) {
        return orderService.placeOrder(userId);
    }

    @GetMapping("/{userId}")
    public List<Order> getUserOrders(@PathVariable Long userId) {
        return orderService.getUserOrders(userId);
    }
}
