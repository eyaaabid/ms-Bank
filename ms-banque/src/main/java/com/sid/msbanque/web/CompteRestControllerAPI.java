package com.sid.msbanque.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sid.msbanque.entities.Compte;
import com.sid.msbanque.repositories.CompteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;



@RestController
@RequestMapping("/banque")
public class CompteRestControllerAPI {
	@Autowired
	private CompteRepository compteRepository;
	@GetMapping(path="/comptes",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}) 
	public List<Compte> compteList(){
		return compteRepository.findAll();
		
	}
	

	@GetMapping("/comptes/{id}")

	public Compte getOne(@PathVariable Long id){
		return compteRepository.findById(id).get();
		
	}
	
	
	@PostMapping(path="/comptes")
	public Compte save(@RequestBody Compte compte){
		return compteRepository.save(compte);
		
	}
	

	
	@PutMapping("/comptes/{id}")
	public Compte update (@RequestBody  Compte compte , @PathVariable Long id){
		compte.setId(id);
		return compteRepository.save(compte);
		
	}
	
	
	@DeleteMapping("/comptes/{id}")
	public void  delete (@PathVariable Long id){
		compteRepository.deleteById(id);
		
	}


}
