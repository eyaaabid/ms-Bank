package com.sid.msbanque;



import java.sql.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.sid.msbanque.entities.Compte;
import com.sid.msbanque.entities.TypeCompte;
import com.sid.msbanque.repositories.CompteRepository;

@SpringBootApplication
public class MsBanqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBanqueApplication.class, args);
	}
	
	
	@Bean
	CommandLineRunner Start(CompteRepository compteRepository, RepositoryRestConfiguration restConfiguration) {
		return args -> {
			
			restConfiguration.exposeIdsFor(Compte.class);
			compteRepository.save(new Compte(null,Math.random()*9000, new Date(1), TypeCompte.Epargne));
			compteRepository.save(new Compte(null,Math.random()*9000, new Date(0), TypeCompte.Courant));
			compteRepository.save(new Compte(null,Math.random()*9000, new Date(0), TypeCompte.Epargne));
			compteRepository.save(new Compte(null,Math.random()*9000, new Date(0), TypeCompte.Courant));
			compteRepository.save(new Compte(null,Math.random()*9000, new Date(0), TypeCompte.Courant));
			compteRepository.save(new Compte(null,Math.random()*9000, new Date(0), TypeCompte.Epargne));
			compteRepository.save(new Compte(null,Math.random()*9000, new Date(0), TypeCompte.Courant));
			compteRepository.save(new Compte(null,Math.random()*9000, new Date(0), TypeCompte.Epargne));


			
			compteRepository.findAll().forEach( c -> {
				System.out.println(c.toString());
			});
		};
	}

}
