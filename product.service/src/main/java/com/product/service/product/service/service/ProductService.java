package com.product.service.product.service.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.product.service.product.service.model.Product;
import com.product.service.product.service.repository.ProductRepository;

@Component
public class ProductService {
	
	@Autowired
	ProductRepository productRepo;
	
	public Product createProduct(Product product) {
		
		UUID id = UUID.randomUUID();
		String idString = id.toString();
		
		product.setId(idString);
		
		System.err.println("PRODUCT TO SAVE: " + product.toString());
		
		productRepo.saveAndFlush(product);
		
		Optional<Product> result = productRepo.findById(idString);
		return result.get();
	}

	public Product findById(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
