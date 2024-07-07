package com.ddlab.rnd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Address")
@Table(name = "Address")
@Getter
@Setter
@ToString
public class Address {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "city")
	private String city;

}
