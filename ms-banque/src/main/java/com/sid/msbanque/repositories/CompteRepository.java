 package com.sid.msbanque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sid.msbanque.entities.Compte;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte,Long> {
	
	

}
