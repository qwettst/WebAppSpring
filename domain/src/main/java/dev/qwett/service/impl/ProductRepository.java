package dev.qwett.service.impl;

import dev.qwett.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

interface ProductRepository extends JpaRepository<Product, Integer> {
}
