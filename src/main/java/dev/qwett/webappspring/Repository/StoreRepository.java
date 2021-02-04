package dev.qwett.webappspring.Repository;

import dev.qwett.webappspring.Entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Integer> {
}
