package com.simplon.course_voilier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.simplon.course_voilier.model.Entreprise;
import com.simplon.course_voilier.service.EntrepriseService;

@Controller
public class EntrepriseController {

	@Autowired
	EntrepriseService es;
	
	@GetMapping("/sponsors")
	public String getSponsor(Model model) {
		
		model.addAttribute("sponsors", es.getAllSponsor());
		return "publicTemplates/sponsors";
	}
	
	@GetMapping("/admin/sponsors")
	public String adminSponsor(Model model) {
		
		model.addAttribute("action", "sponsors");
		model.addAttribute("titres", Entreprise.getAttributes());
		model.addAttribute("objets", es.getAllSponsor());
		model.addAttribute("attributs", Entreprise.getAttributesType());
		model.addAttribute("newObject", new Entreprise());
		return "adminTemplates/gestion";
	}
	
	@PostMapping("/admin/sponsors/ajout")
	public String addSponsor(@ModelAttribute Entreprise entreprise) {
		es.addSponsor(entreprise);
		
		return "redirect:/admin/sponsors";
	}
}
