package com.cg.service;

import com.cg.entity.Admin;
import com.cg.exception.AdminIdNotFoundException;

public interface IAdminService {
	//public Admin addNewAdmin(Admin admin) ;
	public Admin signIn(int userId,Admin admin) throws AdminIdNotFoundException;
	public String signOut(int userId);
	public Admin updtaePassword(int id,Admin admin) throws AdminIdNotFoundException;
	
	
		
	

}
