package com.simplon.course_voilier.service;

import java.util.Optional;

import javax.annotation.Resource;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplon.course_voilier.model.Admin;
import com.simplon.course_voilier.repository.AdminRepo;

@Service
public class AdminService {

	@Autowired
	AdminRepo ar;

	@Resource(name = "cryptor")
	StandardPBEStringEncryptor decryptor;
	
	public Admin connexion(String username, String password) {
		
		Optional<Admin> admin = ar.findById(username);
		if(admin.isPresent()) {
	        return password.equals(decryptor.decrypt(admin.get().getMdp())) ? admin.get() : null;
		}
		else {
			return null;
		}
	}
}
