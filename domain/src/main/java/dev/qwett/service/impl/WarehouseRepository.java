package dev.qwett.service.impl;

import dev.qwett.entities.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {
}
