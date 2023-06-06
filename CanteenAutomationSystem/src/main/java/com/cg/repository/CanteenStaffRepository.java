package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.dto.CanteenStaffDto;
import com.cg.entity.CanteenStaff;

public interface CanteenStaffRepository extends JpaRepository<CanteenStaff, Long> {
CanteenStaff findByUserName(String string);
}
