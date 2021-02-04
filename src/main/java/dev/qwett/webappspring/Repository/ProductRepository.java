package dev.qwett.webappspring.Repository;

import dev.qwett.webappspring.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
