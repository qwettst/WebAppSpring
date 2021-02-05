package dev.qwett.webappspring.repository;

import dev.qwett.webappspring.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
}
