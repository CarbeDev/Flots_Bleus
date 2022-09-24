package com.simplon.course_voilier.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.simplon.course_voilier.model.EquipageModel;
import com.simplon.course_voilier.service.EquipageService;

@Controller
public class EquipageController {
	@Autowired
	private EquipageService es;
	

	
	
	@GetMapping("/equipage")
	public String getequipage(@RequestParam int id, Model model){
		model.addAttribute("equipage", es.getequipage(id).get());
		model.addAttribute("equipages", es.getEquipages());
		
		return "publicTemplates/equipage";
		
		
	
		
	}
	
	
}
