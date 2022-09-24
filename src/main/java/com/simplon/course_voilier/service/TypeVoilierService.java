package com.simplon.course_voilier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplon.course_voilier.model.TypeVoilier;
import com.simplon.course_voilier.repository.TypeVoilierRepo;

@Service
public class TypeVoilierService {

	@Autowired
	TypeVoilierRepo tvr;
	
	public Iterable<TypeVoilier> getAllTypeVoilier() {
		return tvr.findAll();
	}
	
	public void addTypeVoilier(TypeVoilier tv) {
		tvr.save(tv);
	}
}
