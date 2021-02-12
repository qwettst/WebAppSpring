package dev.qwett.webappspring.services.impl;

import dev.qwett.webappspring.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

interface ProductRepository extends JpaRepository<Product, Integer> {
}
