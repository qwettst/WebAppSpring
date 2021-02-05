package dev.qwett.webappspring.repository;

import dev.qwett.webappspring.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Integer> {
}
