package com.cg.service.seviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Admin;
import com.cg.exception.AdminIdNotFoundException;
import com.cg.exception.OrderNotFoundException;
import com.cg.exception.PassWordWrongException;
import com.cg.exception.StaffNotFoundException;
import com.cg.repository.AdminRepository;
import com.cg.service.IAdminService;
@Service
public class AdminServiceImpl implements IAdminService{
	@Autowired
	AdminRepository repo;

	@Override
	public Admin signIn(int userId,Admin admin) throws AdminIdNotFoundException  {
		// TODO Auto-generated method stub
		Optional<Admin> admin1=repo.findById(userId);
		String userInName=admin.getUserName();
		String userInpwd=admin.getPassword();
		if((admin1.isPresent()))
		{
	      String pwd=admin1.get().getPassword();
	      if(pwd.equals(userInpwd)) {
	    	
	    	  return admin;
	      }
	      else {
	    	  throw new PassWordWrongException("ur password is wrong");
	      }
		}
	      
	      else {
	    	 throw new AdminIdNotFoundException("not found");
	      }
		
		}
	
	@Override
	public String signOut(int userId) {
		// TODO Auto-generated method stub
		Admin obj=repo.findById(userId).orElseThrow(()->new AdminIdNotFoundException("js"));
		repo.delete(obj);
		return "logged out succesfully";
	}

	@Override
	public Admin updtaePassword(int id,Admin admin) throws AdminIdNotFoundException {
		// TODO Auto-generated method stub
         Optional<Admin> admin1=repo.findById(id);
		
		String userInName=admin.getUserName();
		String userInpwd=admin.getPassword();
		if((admin1.isPresent()))
		{
	    	  admin1.get().setPassword(admin.getPassword());
	    	  admin1.get().setUserName(admin.getUserName());
	    	  repo.save(admin1.get());
	    	  return admin;
	      }
	   
	      else {
	    	 throw new AdminIdNotFoundException("not found");
	      }
	}

}
