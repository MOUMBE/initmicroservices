package fr.dauphine.m2.productservice.load;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.dauphine.m2.productservice.models.Product;
import fr.dauphine.m2.productservice.repository.ProductRepository;
import jakarta.annotation.PostConstruct;

@Component
public class InitializeComponent {

	private static final Logger LOG = LoggerFactory.getLogger(InitializeComponent.class);
	
	private @Autowired ProductRepository productRepository;
	
	
	@PostConstruct
	private void init() {
		LOG.info("Start");
		productRepository.deleteAll();
		
		Product product = new Product();
		product.setDescription("Mon product 1");
		productRepository.save(product);
		LOG.info("END");
	}
}
