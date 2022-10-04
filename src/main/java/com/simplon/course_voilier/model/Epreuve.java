package com.simplon.course_voilier.model;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name="epreuve")
public class Epreuve implements Model{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_epreuve")
	private int id;

	private String depart;
	private String arrivee;
	
	@Column(name="date_epreuve")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "id_course", referencedColumnName = "id_course")
	private Course course;
	
	public ArrayList<String> getAttributesValues() {
		ArrayList<String> r = new ArrayList<>();
		Locale locale = new Locale("fr", "FR");
		DateFormat dateformat = DateFormat.getDateInstance(DateFormat.DEFAULT,locale);
		
		r.add(String.valueOf(this.id));
		r.add(this.depart);
		r.add(String.valueOf(this.arrivee));
		r.add(dateformat.format(this.date));
		
		return r;
	}
	
	public static ArrayList<String> getAttributes() {
		return Model.getAttributes(Epreuve.class);
	}
	
	public static ArrayList<String> getAttributesType(){
		return Model.getAttributesClass(Epreuve.class);
	}


}
