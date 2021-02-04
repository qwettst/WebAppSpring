package dev.qwett.webappspring.Repository;

import dev.qwett.webappspring.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
