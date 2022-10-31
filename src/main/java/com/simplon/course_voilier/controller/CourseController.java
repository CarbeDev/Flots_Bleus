package com.simplon.course_voilier.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.simplon.course_voilier.model.Course;
import com.simplon.course_voilier.model.Epreuve;
import com.simplon.course_voilier.model.Inscription;
import com.simplon.course_voilier.service.CourseService;
import com.simplon.course_voilier.service.EpreuveService;
import com.simplon.course_voilier.service.InscriptionService;

@Controller
public class CourseController {

	@Autowired
	CourseService cs;
	@Autowired
	InscriptionService is;
	@Autowired
	EpreuveService es;
	
	@GetMapping("/courses")
	public String getAllCourses(Model model) {
	 model.addAttribute("courses",cs.getAllCourse());
	 return "publicTemplates/courses";
	}
	
//	@GetMapping("/classement")
//	public String getClassement(Model model) {
//	    model.addAttribute("classement,"cs.)
//	}
	
	
	@GetMapping("/admin/courses")
	public String getCourses(Model model) {
		model.addAttribute("action", "courses");
		model.addAttribute("titres", Course.getAttributes());
		model.addAttribute("objets", cs.getAllCourse());
		model.addAttribute("attributs", Course.getAttributesType());
		model.addAttribute("newObject", new Course());
		return "adminTemplates/gestion";
	}
	
	@PostMapping("/admin/courses/ajout")
	public String addCourse(@ModelAttribute Course course) {
		cs.addCourse(course);
		
		return "redirect:/admin/courses/" + course.getId();
	}
	
	@GetMapping("/admin/courses/{id}")
	public String updateCourses(@PathVariable int id,Model model) {
		return "update_course";
	}
	
	@GetMapping("/admin/courses/{id}/inscription")
	public String inscriptionbyCourse(@PathVariable int id, Model model) {
		Inscription inscription = new Inscription();
		inscription.setCourse(cs.getCourse(id).get());
		
		model.addAttribute("action", "inscription");
		model.addAttribute("titres", Inscription.getAttributes());
		model.addAttribute("objets", is.getInscription(id));
		model.addAttribute("attributs", Inscription.getAttributesType());
		model.addAttribute("newObject", inscription);
		
		return "adminTemplates/gestion";
	}
	
	@GetMapping("/admin/courses/{id}/epreuves")
	public String epreuvebyCourse(@PathVariable int id, Model model) {
		
		ArrayList<String> titres = Epreuve.getAttributes();
		titres.remove(4);
		
		ArrayList<String> attributs = Epreuve.getAttributesType();
		attributs.remove(4);
		
		model.addAttribute("action", "/admin/courses/"+id+"/epreuves/ajout");
		model.addAttribute("titres", titres);
		model.addAttribute("objets", es.getEpreuve(id));
		model.addAttribute("attributs", attributs);
		model.addAttribute("newObject", new Epreuve());
		
		return "adminTemplates/gestion";
	}
	
	@PostMapping("admin/courses/{id}/epreuves/ajout")
	public String addEpreuve(@PathVariable int id, @ModelAttribute Epreuve epreuve, Model model) {
		epreuve.setCourse(cs.getCourse(id).get());
		es.addEpreuve(epreuve);
		
		return "redirect:admin/course/" + id + "/epreuves";
	}
}
