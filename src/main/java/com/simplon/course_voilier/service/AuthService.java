package com.simplon.course_voilier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.simplon.course_voilier.model.Admin;
import com.simplon.course_voilier.repository.AdminRepo;

@Service
public class AuthService {

	@Autowired
	private AdminRepo ar;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public void createNewAdmin(Admin admin) {
		admin.setMdp(encoder.encode(admin.getMdp()));
		ar.save(admin);
	}
}
