package dev.qwett.webappspring.service.impl;

import dev.qwett.webappspring.entities.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {
}
