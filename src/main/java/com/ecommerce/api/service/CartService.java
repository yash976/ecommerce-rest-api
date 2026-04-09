package com.ecommerce.api.service;

import com.ecommerce.api.model.CartItem;
import com.ecommerce.api.repository.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartItemRepository cartItemRepository;

    public CartItem addToCart(Long userId, Long productId, int quantity) {
        CartItem item = CartItem.builder()
                .userId(userId)
                .productId(productId)
                .quantity(quantity)
                .build();

        return cartItemRepository.save(item);
    }

    public List<CartItem> getUserCart(Long userId) {
        return cartItemRepository.findByUserId(userId);
    }

    public void removeItem(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    public void clearCart(Long userId) {
        cartItemRepository.deleteByUserId(userId);
    }
}
