package dev.qwett.webappspring.repository;

import dev.qwett.webappspring.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
}
