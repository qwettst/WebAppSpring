package dev.qwett.webappspring.repository;

import dev.qwett.webappspring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
