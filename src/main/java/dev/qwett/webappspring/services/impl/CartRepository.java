package dev.qwett.webappspring.services.impl;

import dev.qwett.webappspring.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

interface CartRepository extends JpaRepository<Cart, Integer> {
}
