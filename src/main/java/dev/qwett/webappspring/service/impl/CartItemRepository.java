package dev.qwett.webappspring.service.impl;

import dev.qwett.webappspring.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

interface CartItemRepository extends JpaRepository<CartItem, Integer> {
}
