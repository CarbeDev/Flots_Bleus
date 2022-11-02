package com.simplon.course_voilier.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplon.course_voilier.model.Course;
import com.simplon.course_voilier.repository.CourseRepo;

@Service
public class CourseService {

	@Autowired
	CourseRepo cr;
	
	public Iterable<Course> getAllCourse() {
		return cr.findAll();
	}
	
	public void addCourse(Course course) {
		cr.save(course);
	}
	
	public Optional<Course> getCourse(int id){
		return cr.findById(id);
	}

    public void removeCourse(int id){
        cr.deleteById(id);
    }
}
