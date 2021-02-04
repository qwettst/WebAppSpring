package dev.qwett.webappspring.Repository;

import dev.qwett.webappspring.Entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
}
