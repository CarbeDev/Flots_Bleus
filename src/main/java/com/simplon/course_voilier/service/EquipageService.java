package com.simplon.course_voilier.service;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simplon.course_voilier.model.EquipageModel;
import com.simplon.course_voilier.repository.EquipageRepository;

@Service
public class EquipageService {

	@Autowired
	private EquipageRepository er;

	public Optional<EquipageModel> getequipage(int id) {
		return er.findById(id);
	}

	public Iterable<EquipageModel> getEquipages() {
		return er.findAll();
	}

	
};