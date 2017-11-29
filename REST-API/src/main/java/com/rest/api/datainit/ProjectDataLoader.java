package com.rest.api.datainit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.rest.api.model.Ressource;
import com.rest.api.repository.RessourceRepository;


@Component
public class ProjectDataLoader implements ApplicationRunner {
	@Autowired
	RessourceRepository ressourceRepository;
	
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
	ressourceRepository.save(new Ressource("Souhail","AIT SAID","IDN536"));
	ressourceRepository.save(new Ressource("YouSASA","AIT SAID","CIs6"));
	ressourceRepository.save(new Ressource("YouQQs","AIT SAID","CaI536"));
	ressourceRepository.save(new Ressource("Yougges","AsID","CI53p"));
	ressourceRepository.save(new Ressource("Younes","AITliAID","CIa36"));
	ressourceRepository.save(new Ressource("Younes","AIT SAID","CI5s6"));
		
	}

}
