package com.ramesh.springdata.product.contry;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramesh.springdata.product.entities.Product;
import com.ramesh.springdata.product.repos.ProductRepository;
@RestController
@RequestMapping("/api/Product")
public class MainController 
{
	
	
	
	
	    @Autowired
	    private ProductRepository ProductRepository;

	    @GetMapping
	    public List<Product> getAllProducts() {
	        return (List<Product>) ProductRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public Product getProductById(@PathVariable Iterable<Integer> id) {
	        return (Product) ((Object) ProductRepository.findAllById(id));
	    }

	    @PostMapping
	    public Product createProduct(@RequestBody Product product) {
	        return ProductRepository.save(product);
	    }

	    @PutMapping("/{id}")
	    public Product updateProduct(@PathVariable Iterable<Integer> id, @RequestBody Product updatedProduct) {
	        Product existingProduct = (Product) ((Object) ProductRepository.findAllById(id));
	        if (existingProduct != null) {
	            existingProduct.setName(updatedProduct.getName());
	            existingProduct.setPrice(updatedProduct.getPrice());
	            return ProductRepository.save(existingProduct);
	        } else {
	            return null; // Handle not found scenario
	        }
	    }

	    @DeleteMapping("/{id}")
	    public void deleteProduct(@PathVariable Integer id) {
	        ProductRepository.deleteById(id);
	    }
	    
	}


