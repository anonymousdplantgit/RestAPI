package com.rest.api.controller;

import java.security.Principal;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.rest.api.model.Product;
import com.rest.api.repository.ProductRepository;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	private static Sort SORTING_DESC = new Sort(Sort.Direction.DESC, "productId");

	@GetMapping()
	public ResponseEntity<List<Product>> home(Model model, Principal principal) throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
		List<Product> list = productRepository.findAll(SORTING_DESC);
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);

	}
	@PostMapping()
	public ResponseEntity<Void> save(@RequestBody Product product, UriComponentsBuilder builder) {
		try {
			productRepository.save(product);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/find/{id}").buildAndExpand(product.getProductId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<Product> find(@PathVariable("id") Long id) {
		Product r = null;
		try {
			r = productRepository.findOne(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Product>(r, HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
		try {
			productRepository.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Boolean>(false,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	}
}