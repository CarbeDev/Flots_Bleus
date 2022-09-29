package com.simplon.course_voilier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.simplon.course_voilier.model.Course;
import com.simplon.course_voilier.model.Inscription;
import com.simplon.course_voilier.service.CourseService;
import com.simplon.course_voilier.service.InscriptionService;

@Controller
public class CourseController {

	@Autowired
	CourseService cs;
	
	@Autowired
	InscriptionService is;
	
	@GetMapping("/admin/courses")
	public String getCourses(Model model) {
		model.addAttribute("type", "courses");
		model.addAttribute("titres", Course.getAttributes());
		model.addAttribute("objets", cs.getAllCourse());
		model.addAttribute("attributs", Course.getAttributesType());
		model.addAttribute("newObject", new Course());
		return "gestion";
	}
	
	@PostMapping("/admin/courses/ajout")
	public String addCourse(@ModelAttribute Course course) {
		cs.addCourse(course);
		
		return "redirect:/admin/courses/" + course.getId();
	}
	
	@GetMapping("/admin/courses/{id}")
	public String updateCourses(@PathVariable int id,Model model) {
		model.addAttribute("type", "inscription");
		model.addAttribute("titres", Inscription.getAttributes());
		model.addAttribute("objets", is.getInscription(id));
		model.addAttribute("attributs", Inscription.getAttributesType());
		model.addAttribute("newObject", new Inscription());
		
		return "gestion";
	}
}
