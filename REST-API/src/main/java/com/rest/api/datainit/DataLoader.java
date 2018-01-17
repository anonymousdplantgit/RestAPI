package com.rest.api.datainit;

import java.math.BigDecimal;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.rest.api.model.Product;
import com.rest.api.model.Ressource;
import com.rest.api.repository.ProductRepository;
import com.rest.api.repository.RessourceRepository;


@Component
public class DataLoader implements ApplicationRunner {
	@Autowired
	RessourceRepository ressourceRepository;
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
	ressourceRepository.save(new Ressource("Souhail","AIT SAID","IDN536"));
	ressourceRepository.save(new Ressource("YouSASA","AIT SAID","CIs6"));
	ressourceRepository.save(new Ressource("YouQQs","AIT SAID","CaI536"));
	ressourceRepository.save(new Ressource("Yougges","AsID","CI53p"));
	ressourceRepository.save(new Ressource("Younes","AITliAID","CIa36"));
	ressourceRepository.save(new Ressource("Younes","AIT SAID","CI5s6"));
	productRepository.save(new Product("PRD1", "Produit 1", "Produit 1 de test", BigDecimal.valueOf(RandomUtils.nextDouble(Double.valueOf(15.05),Double.valueOf(20.05))),BigDecimal.valueOf(RandomUtils.nextDouble(Double.valueOf(20.05),Double.valueOf(25.05)))));
	productRepository.save(new Product("PRD2", "Produit 2", "Produit 2 de test", BigDecimal.valueOf(RandomUtils.nextDouble(Double.valueOf(15.05),Double.valueOf(20.05))),BigDecimal.valueOf(RandomUtils.nextDouble(Double.valueOf(20.05),Double.valueOf(25.05)))));
	productRepository.save(new Product("PRD3", "Produit 3", "Produit 3 de test", BigDecimal.valueOf(RandomUtils.nextDouble(Double.valueOf(15.05),Double.valueOf(20.05))),BigDecimal.valueOf(RandomUtils.nextDouble(Double.valueOf(20.05),Double.valueOf(25.05)))));
	productRepository.save(new Product("PRD4", "Produit 4", "Produit 4 de test", BigDecimal.valueOf(RandomUtils.nextDouble(Double.valueOf(15.05),Double.valueOf(20.05))),BigDecimal.valueOf(RandomUtils.nextDouble(Double.valueOf(20.05),Double.valueOf(25.05)))));
	productRepository.save(new Product("PRD5", "Produit 5", "Produit 5 de test", BigDecimal.valueOf(RandomUtils.nextDouble(Double.valueOf(15.05),Double.valueOf(20.05))),BigDecimal.valueOf(RandomUtils.nextDouble(Double.valueOf(20.05),Double.valueOf(25.05)))));
	productRepository.save(new Product("PRD6", "Produit 6", "Produit 6 de test", BigDecimal.valueOf(RandomUtils.nextDouble(Double.valueOf(15.05),Double.valueOf(20.05))),BigDecimal.valueOf(RandomUtils.nextDouble(Double.valueOf(20.05),Double.valueOf(25.05)))));
	productRepository.save(new Product("PRD7", "Produit 7", "Produit 7 de test", BigDecimal.valueOf(RandomUtils.nextDouble(Double.valueOf(15.05),Double.valueOf(20.05))),BigDecimal.valueOf(RandomUtils.nextDouble(Double.valueOf(20.05),Double.valueOf(25.05)))));
	productRepository.save(new Product("PRD8", "Produit 8", "Produit 8 de test", BigDecimal.valueOf(RandomUtils.nextDouble(Double.valueOf(15.05),Double.valueOf(20.05))),BigDecimal.valueOf(RandomUtils.nextDouble(Double.valueOf(20.05),Double.valueOf(25.05)))));
	productRepository.save(new Product("PRD9", "Produit 9", "Produit 9 de test", BigDecimal.valueOf(RandomUtils.nextDouble(Double.valueOf(15.05),Double.valueOf(20.05))),BigDecimal.valueOf(RandomUtils.nextDouble(Double.valueOf(20.05),Double.valueOf(25.05)))));
	}

}
