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

import com.rest.api.model.Ressource;
import com.rest.api.repository.RessourceRepository;

@RestController
@RequestMapping("/ressources")
@CrossOrigin(origins = "*")
public class RessourceController {
	@Autowired
	private RessourceRepository ressourceRepository;
	private static Sort SORTING_DESC = new Sort(Sort.Direction.DESC, "ressourceId");

	@GetMapping("/")
	public ResponseEntity<List<Ressource>> home(Model model, Principal principal) throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
		return new ResponseEntity<List<Ressource>>(ressourceRepository.findAll(SORTING_DESC), HttpStatus.OK);

	}

	@PostMapping("/save")
	public ResponseEntity<Void> save(@RequestBody Ressource ressource, UriComponentsBuilder builder) {
		try {
			ressourceRepository.save(ressource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/find/{id}").buildAndExpand(ressource.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Ressource> find(@PathVariable("id") Long id) {
		Ressource r = null;
		try {
			r = ressourceRepository.findOne(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Ressource>(r, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		try {
			ressourceRepository.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}