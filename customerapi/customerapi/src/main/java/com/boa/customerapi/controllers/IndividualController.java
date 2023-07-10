package com.boa.customerapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boa.customerapi.models.Individual;
import com.boa.customerapi.services.IndividualService;
import com.boa.customerapi.vos.ResponseWrapper;

@RestController
@RequestMapping("/individuals")
public class IndividualController {
	
	@Autowired
	private IndividualService individualService;
	
	
	//add the individual
	
	@SuppressWarnings("rawtypes")
	@PostMapping({"/v1.0/"})
    @CrossOrigin("*")
	public ResponseEntity<ResponseWrapper> addIndividual(@RequestBody Individual individual){
	
		Individual object=this.individualService.addIndividual(individual);
		if(object !=null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper<Individual>(object));
			
		}
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper("Customer "
					+ "not created"));
			
		
	}
	
	@GetMapping({"/v1.0/"})
	@CrossOrigin("*")
	public List<Individual> getAllIndividuals(){
	
	   return this.individualService.getAllIndividuals();
		
	}
	
	

}
