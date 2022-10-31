package com.simplon.course_voilier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.simplon.course_voilier.model.Admin;
import com.simplon.course_voilier.service.AuthService;

@Controller
public class AuthController {

	@Autowired
	AuthService as;
	
	@GetMapping("/admin")
	public String connexion(Model model,boolean erreur,boolean deco) {	
		
		if(erreur)model.addAttribute("erreur", "Mauvais identifiant et/ou mot de passe");
		if(deco)model.addAttribute("info", "Déconnexion réussie");
				
		return "admintemplates/connexion";
	}
	
}
