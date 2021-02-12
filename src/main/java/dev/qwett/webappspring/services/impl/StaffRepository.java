package dev.qwett.webappspring.services.impl;

import dev.qwett.webappspring.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

interface StaffRepository extends JpaRepository<Staff, Integer> {
}
