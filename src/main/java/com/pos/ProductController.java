package com.pos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;

	@GetMapping("/product")
	public List<Product> saveProduct(Product product) {
		return productRepository.findAll();
		
	}
	
	/* GET SINGLE PRODUCT */
	@GetMapping("/product/{id}")
	public Optional<Product> getProductById(@PathVariable(value="id") Long productid) {
		return productRepository.findById(productid);
	   
	}
	
	@PostMapping("/product")
	public Product postProduct(@RequestBody Product product){
	    Product temp_product = new Product();
	    temp_product.setId(product.getId());
	    temp_product.setProductName(product.getProductName());
	    temp_product.setQty(product.getQty());
	    temp_product.setPrice(product.getPrice());
		return productRepository.save(temp_product);
		
	} 
	
	@DeleteMapping("/product/{id}")
	public void deleteProduct(@PathVariable("id") String id){
		
		productRepository.findAll().forEach((Product product)->{
			if(product.getId() == Integer.parseInt(id)) {
				productRepository.delete(product);
			}
				
		});
	
	}
	

}
