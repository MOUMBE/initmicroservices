package fr.dauphine.m2.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dauphine.m2.productservice.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
