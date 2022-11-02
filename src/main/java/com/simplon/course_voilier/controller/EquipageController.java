package com.simplon.course_voilier.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.simplon.course_voilier.model.Equipage;
import com.simplon.course_voilier.model.EquipageModel;
import com.simplon.course_voilier.model.Inscription;
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
	
	@GetMapping("admin/equipages")
    public String addequipage(Model model) {
        model.addAttribute("action","equipage");
        model.addAttribute("titres", Equipage.getAttributes());
        model.addAttribute("objets", es.getEquipages());
        model.addAttribute("attributs",Equipage.getAttributesType());
        model.addAttribute("newObject", new Equipage());
        
        return "adminTemplates/gestion";
    }
	
	@PostMapping("admin/equipage/ajout")
	public String addEquipage(@ModelAttribute Equipage equipage) {
	    es.addequipage(equipage);
	    return "redirect:/admin/equipage";
	        
	}
	
}
