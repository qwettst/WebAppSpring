package dev.qwett.webappspring.Repository;

import dev.qwett.webappspring.Entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {
}
