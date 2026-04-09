package com.ecommerce.api.controller;

import com.ecommerce.api.model.CartItem;
import com.ecommerce.api.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("/add")
    public CartItem addToCart(@RequestParam Long userId,
                              @RequestParam Long productId,
                              @RequestParam int quantity) {

        return cartService.addToCart(userId, productId, quantity);
    }

    @GetMapping("/{userId}")
    public List<CartItem> getCart(@PathVariable Long userId) {
        return cartService.getUserCart(userId);
    }

    @DeleteMapping("/remove/{id}")
    public String removeItem(@PathVariable Long id) {
        cartService.removeItem(id);
        return "Item removed";
    }

    @DeleteMapping("/clear/{userId}")
    public String clearCart(@PathVariable Long userId) {
        cartService.clearCart(userId);
        return "Cart cleared";
    }
}
