package fr.dauphine.m2.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {

	@Id
	@GeneratedValue
	private Long id;
	private String description;
	private String color;
	private int weight;
	private String productImgUrl; // Lien vers image du product du fournisseur
}
