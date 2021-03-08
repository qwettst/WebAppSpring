package dev.qwett.service.impl;

import dev.qwett.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

interface StaffRepository extends JpaRepository<Staff, Integer> {
}
