package com.simplon.course_voilier.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name="admin")
public class Admin {

	@Id
	private String identifiant;
	private String mdp;
	@Transient
	private String confirmMdp;
	
}
