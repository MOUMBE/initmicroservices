package fr.dauphine.m2.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Supplier {
	
	@Id
	private Long id;
	private String address;
	private String country;
}
