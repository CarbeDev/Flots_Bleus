package com.simplon.course_voilier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplon.course_voilier.model.Inscription;
import com.simplon.course_voilier.repository.InscriptionRepo;

@Service
public class InscriptionService {

	@Autowired
	InscriptionRepo ir;
	
	public Iterable<Inscription> getInscription(int idCourse) {
		return ir.findByIdCourse(idCourse);
	}
	
	public void addInscription(Inscription inscription) {
		ir.save(inscription);
	}
}