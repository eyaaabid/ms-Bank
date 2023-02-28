package com.sid.msbanque.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sid.msbanque.entities.Compte;
import com.sid.msbanque.repositories.CompteRepository;

import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Component
@Path("/banque")
public class CompteRestJaxRSAPI {
	
	@Autowired
	private CompteRepository compteRepository;
	@Path("/comptes")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) 
	public List<Compte> compteList(){
		return compteRepository.findAll();
		
	}
	
	
	@Path("/banque/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON) 
	public Compte getOne(@PathParam(value = "id") Long id){
		return compteRepository.findById(id).get();
		
	}
	
	@Path("/comptes")
	@POST
	@Produces(MediaType.APPLICATION_JSON) 
	public Compte save(Compte compte){
		return compteRepository.save(compte);
		
	}
	

	@Path("/comptes/{id}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON) 
	public Compte update (Compte compte , @PathParam("id") Long id){
		compte.setId(id);
		return compteRepository.save(compte);
		
	}
	
	@Path("/comptes/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON) 
	public void  delete (@PathParam("id") Long id){
		compteRepository.deleteById(id);
		
	}

}
