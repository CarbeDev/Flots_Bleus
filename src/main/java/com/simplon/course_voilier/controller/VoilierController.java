package com.simplon.course_voilier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.simplon.course_voilier.model.TypeVoilier;
import com.simplon.course_voilier.model.Voilier;
import com.simplon.course_voilier.service.TypeVoilierService;
import com.simplon.course_voilier.service.VoilierService;

@Controller
public class VoilierController {

	@Autowired
	VoilierService vs;
	
	@Autowired
	TypeVoilierService tvs;
	
	@GetMapping("admin/voiliers")
	public String adminVoilier(Model model) {
		model.addAttribute("type", "voiliers");
		model.addAttribute("titres", Voilier.getAttributes());
		model.addAttribute("objets", vs.getAllVoilier());
		model.addAttribute("attributs", Voilier.getAttributesType());
		model.addAttribute("newObject", new Voilier());
		return "gestion";
	}
	
	@PostMapping("admin/voiliers/ajout")
	public String addVoilier(@ModelAttribute Voilier voilier) {
		vs.addVoilier(voilier);
		
		return "redirect:/admin/voiliers";
	}
	
	@GetMapping("admin/type_voilier")
	public String adminTypeVoilier(Model model) {
		model.addAttribute("type", "type_voilier");
		model.addAttribute("titres", TypeVoilier.getAttributes());
		model.addAttribute("objets", tvs.getAllTypeVoilier());
		model.addAttribute("attributs", TypeVoilier.getAttributesType());
		model.addAttribute("newObject", new TypeVoilier());
		
		return "gestion";
	}
	
	@PostMapping("admin/type_voilier/ajout")
	public String addTypeVoilier(@ModelAttribute TypeVoilier tv) {
		tvs.addTypeVoilier(tv);
		
		return "redirect:/admin/type_voilier";
	}
	
}
