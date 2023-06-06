package com.cg.service;

import java.util.List;

import com.cg.dto.CanteenStaffDto;
public interface ICanteenStaffService {
	List<CanteenStaffDto> getAllStaff();
	CanteenStaffDto getStaffById(long staffId);
	CanteenStaffDto saveStaff(CanteenStaffDto staff);
	CanteenStaffDto updateStaff(Long staffId,CanteenStaffDto staff);
	void deleteStaff(Long staffId);

	
}
