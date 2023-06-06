package com.cg.service.seviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.CanteenStaffDto;
import com.cg.dto.CustomerDto;
import com.cg.entity.CanteenStaff;
import com.cg.entity.Customer;
import com.cg.exception.CustomerNotFoundException;
import com.cg.exception.StaffNotFoundException;
import com.cg.exception.UserAlreadyExistsException;
import com.cg.repository.CanteenStaffRepository;
import com.cg.service.ICanteenStaffService;

@Service
public class CanteenStaffServiceImpl implements ICanteenStaffService{
	@Autowired
    CanteenStaffRepository repo;

	@Override
	public List<CanteenStaffDto> getAllStaff() {
		
			List<CanteenStaffDto> canteenStaffs = new ArrayList<>();
					
			List<CanteenStaff> staffList =repo.findAll();
					
					staffList .stream().forEach(canteenStaff -> {
						//LOGGER.debug("GroundServiceImpl::getAllGrounds::"+ground);
						CanteenStaffDto canteenStaffDto = new CanteenStaffDto();
						canteenStaffDto.setStaffName(canteenStaff.getStaffName());
						canteenStaffDto.setStaffEmail(canteenStaff.getStaffEmail());
						canteenStaffDto.setPassword(canteenStaff.getPassword());
						canteenStaffDto.setStaffId(canteenStaff.getStaffId());
						canteenStaffs.add(canteenStaffDto);
						
				});
					return canteenStaffs;
	}

	@Override
	public CanteenStaffDto getStaffById(long staffId) {
		Optional<CanteenStaff> canteenOpt = repo.findById(staffId);
		CanteenStaffDto  canteenStaffDto = new CanteenStaffDto();
		if(canteenOpt.isPresent()) {
			CanteenStaff canteenStaff =  canteenOpt.get();
			canteenStaffDto.setStaffName(canteenStaff.getStaffName());
			canteenStaffDto.setStaffEmail(canteenStaff.getStaffEmail());
			canteenStaffDto.setStaffId(canteenStaff.getStaffId());
			canteenStaffDto.setPassword(canteenStaff.getPassword());
			
			
			
		}else {
			throw new StaffNotFoundException("staff with id::"+staffId+" Not found");
	}
return canteenStaffDto;
	}

	@Override
	public CanteenStaffDto saveStaff(CanteenStaffDto staff) {
		
		
			CanteenStaff entity = new CanteenStaff();
			//	groundEntity.setGroundId(ground.getGroundId());
		entity.setStaffName(staff.getStaffName());
		entity.setStaffEmail(staff.getStaffEmail());
		entity.setPassword(staff.getPassword());
		repo.save(entity);
				staff.setStaffId(entity.getStaffId());
				return staff;
		
		
	
	
	}

	@Override
	public CanteenStaffDto updateStaff(Long staffId, CanteenStaffDto staff) {
		CanteenStaff canteenStaff = repo.findById(staffId)
				 .orElseThrow(()->new StaffNotFoundException("staff with id::"+staffId+" Not found") )	;
		canteenStaff.setStaffEmail(staff.getStaffEmail());
		canteenStaff.setStaffName(staff.getStaffName());;
		canteenStaff.setPassword(staff.getPassword());
		 repo.save(canteenStaff);						
		return staff;
	}

	@Override
	public void deleteStaff(Long staffId) {
		CanteenStaff canteenStaff = repo.findById(staffId)
				 .orElseThrow(()->new StaffNotFoundException("staff with id::"+staffId+" Not found") );
		repo.deleteById(staffId);
		
	}
    
}
