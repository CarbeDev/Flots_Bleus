package com.simplon.course_voilier.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.simplon.course_voilier.model.Admin;
import com.simplon.course_voilier.repository.AdminRepo;

@Service
public class AdminService implements UserDetailsService{

	@Autowired
	AdminRepo ar;
	
	@Override
	public UserDetails loadUserByUsername(String id) {
		
		Admin admin = ar.findByIdentifiant(id);
		if(admin == null) throw new UsernameNotFoundException(id);
		
		return new org.springframework.security.core.userdetails.User(admin.getIdentifiant(), admin.getMdp(), new HashSet<>());
	}
	
}
