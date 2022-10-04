package com.simplon.course_voilier.model.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InscriptionKey implements Serializable{

	@Column(name="id_course")
	private int idCourse;
	@Column(name="id_voilier")
	private int idVoilier;
	@Column(name="id_equipage")
	private int idEquipage;
}
