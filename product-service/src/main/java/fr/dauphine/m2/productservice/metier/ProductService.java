package fr.dauphine.m2.productservice.metier;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.dauphine.m2.productservice.models.Product;
import fr.dauphine.m2.productservice.repository.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	public ProductService(ProductRepository productRepository) {
		// TODO Auto-generated constructor stub
		this.productRepository = productRepository;
	}
	
	public List<Product> getAll() {
		return productRepository.findAll();
	}
}
