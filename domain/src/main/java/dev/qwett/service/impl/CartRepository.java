package dev.qwett.service.impl;

import dev.qwett.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

interface CartRepository extends JpaRepository<Cart, Integer> {
}
