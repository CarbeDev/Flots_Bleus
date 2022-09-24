package com.simplon.course_voilier.controller;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.simplon.course_voilier.model.Admin;
import com.simplon.course_voilier.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService as;
	
	@GetMapping("/admin")
	public String connexionAdmin(Model model) {	
		model.addAttribute("admin", new Admin());		
		return "connexion";
	}
	
	@PostMapping("/admin")
	public String connexionAdmin(@ModelAttribute Admin admin, Model model, HttpServletResponse response) {
		
		if(as.connexion(admin.getIdentifiant(), admin.getMdp()) == null) {
			model.addAttribute("erreur", "Identifiant et/ou mot de passe incorrect");
			return "connexion";
		}
		else {
			
			Cookie cookie = new Cookie("identifiant", admin.getIdentifiant());
			cookie.setHttpOnly(true);
			cookie.setPath("/");
			
			response.addCookie(cookie);
			
			return "redirect:/admin/index";
		}
	}
	
	@GetMapping("/admin/index")
	public String accueilAdmin(Model model, @CookieValue(value = "identifiant", defaultValue = "none") String id) {
		
		if(id.equals("none")) {
			
			model.addAttribute("erreur", "Vous devez être connecté pour accéder à cette partie du site");
			return "connexion";
			
		} else {
			
			model.addAttribute("identifiant", id);
			return "accueil_admin";
		}
	}
	
	@GetMapping("/admin/deconnexion")
	public String deconnexion(Model model, HttpServletResponse response) {
		
		Cookie cookie = new Cookie("identifiant", null);
		cookie.setMaxAge(0);
		cookie.setHttpOnly(true);
		cookie.setPath("/");
		
		response.addCookie(cookie);
		
		model.addAttribute("info", "Compte déconnecté");
		return "connexion";
		
	}
	
	
	
}
