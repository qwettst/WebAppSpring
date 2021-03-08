package dev.qwett.service.impl;

import dev.qwett.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

interface CartItemRepository extends JpaRepository<CartItem, Integer> {
}
