package com.ddlab.rnd.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Project")
@Table(name = "Project")
@Getter
@Setter
@ToString
public class Project {

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

//	@OneToMany(cascade = CascadeType.ALL)
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Employee> empList;

}
