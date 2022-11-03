package com.simplon.course_voilier.controller;

import java.util.ArrayList;

import com.simplon.course_voilier.model.Resultat;
import com.simplon.course_voilier.model.key.InscriptionKey;
import com.simplon.course_voilier.service.*;
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

@Controller
public class CourseController {

	@Autowired
	CourseService cs;
	@Autowired
	InscriptionService is;
	@Autowired
	EpreuveService es;
	@Autowired
	ResultatService rs;
    @Autowired
	VoilierService vs;

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

        model.addAttribute("course", cs.getCourse(id).get());
		return "adminTemplates/update_course";
	}

    @PostMapping("/admin/courses/{id}/modif")
    public String updateCourse(@ModelAttribute Course course){
        cs.addCourse(course);
        return "redirect:/admin/courses/"+course.getId();
    }

    @GetMapping("/admin/courses/{id}/suppression")
	public String removeCourse(@PathVariable int id){
        cs.removeCourse(id);
        return "redirect:/admin/courses";
    }

	@GetMapping("/admin/courses/{id}/inscriptions")
	public String inscriptionbyCourse(@PathVariable int id, Model model) {
        ArrayList<String> titres = Inscription.getAttributes();
        titres.remove(2);

        ArrayList<String> attributs = Inscription.getAttributesType();
        attributs.remove(2);

        model.addAttribute("action", "inscriptions");
        model.addAttribute("titres", titres);
        model.addAttribute("objets", is.getInscription(id));
        model.addAttribute("attributs", attributs);
        model.addAttribute("newObject", new InscriptionKey());
		
		return "adminTemplates/gestion";
	}

    @PostMapping("/admin/courses/{id}/inscriptions/ajout")
    public String addInscription(@PathVariable int id, @ModelAttribute InscriptionKey ik) {

        Inscription inscription = new Inscription();

        ik.setCourse(id);

        inscription.setId(ik);
        inscription.setDesistement(false);

        for(Epreuve epreuve : es.getEpreuve(id)) {
            rs.addResultat(new Resultat(epreuve,vs.getVoilier(id).get()));
        }

        is.addInscription(inscription);

        return "redirect:/admin/courses/"+id+"/inscriptions";
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
