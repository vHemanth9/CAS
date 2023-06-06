package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import com.cg.entity.Admin; 

import com.cg.exception.AdminIdNotFoundException;
//import com.cg.model.Admin;
import com.cg.service.IAdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {
	@Autowired
	IAdminService service;
	@PostMapping(path = "/AdminlogIn/{userId}")
	public Admin signIn (@PathVariable("userId") int userId,@RequestBody Admin admin) throws AdminIdNotFoundException
	{
		//log.info("Login succefull");
		return service.signIn(userId,admin);
	}
    @PutMapping("/update/{id}")
    public Admin update(@PathVariable("id") int id,@RequestBody Admin admin) throws AdminIdNotFoundException
    {
		return service.updtaePassword(id, admin);
    	
    }
    @DeleteMapping("/sign out/{userId} ")
    public String signOut(@PathVariable("userId")int userId)
    {
    	return service.signOut(userId);
    }
}
