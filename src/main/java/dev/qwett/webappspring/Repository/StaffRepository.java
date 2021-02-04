package dev.qwett.webappspring.Repository;

import dev.qwett.webappspring.Entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
}
