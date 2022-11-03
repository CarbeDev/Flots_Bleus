package com.simplon.course_voilier.service;

import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplon.course_voilier.model.Resultat;
import com.simplon.course_voilier.repository.ResultatRepo;

@Service
public class ResultatService {

	@Autowired
	ResultatRepo rr;

	public Iterable<Resultat> getResultat(int idEpreuve) {
		return rr.findByIdEpreuve(idEpreuve);
	}

	public void addResultat(Resultat r) {
		rr.save(r);
	}

	public void updateResultat(String temps,int idVoilier,int idEpreuve) {
		rr.save(new Resultat(idVoilier,idEpreuve,Time.valueOf(temps)));
    }
}