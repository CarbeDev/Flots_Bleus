package com.simplon.course_voilier.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplon.course_voilier.model.Voilier;
import com.simplon.course_voilier.repository.VoilierRepo;

@Service
public class VoilierService {

	@Autowired
	VoilierRepo vr;
	
	public Iterable<Voilier> getAllVoiliers() {
		return vr.findAll();
	}
	
	public void addVoilier(Voilier voilier) {
		vr.save(voilier);
	}
	
	public Optional<Voilier> getVoilier(int i) {
		return vr.findById(i);
	}
}
