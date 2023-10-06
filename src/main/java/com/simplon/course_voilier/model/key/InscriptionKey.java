package com.simplon.course_voilier.model.key;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
public class InscriptionKey implements Serializable{

	@Column(name="id_course")
	private int course;
	@Column(name="id_voilier")
	private int voilier;
	@Column(name="id_equipage")
	private int equipage;
}
