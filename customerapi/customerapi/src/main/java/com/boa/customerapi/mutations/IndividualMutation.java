package com.boa.customerapi.mutations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boa.customerapi.models.FullName;
import com.boa.customerapi.models.Individual;
import com.boa.customerapi.services.IndividualService;
import com.boa.customerapi.vos.IndividualInput;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class IndividualMutation implements GraphQLMutationResolver{
	@Autowired
	private IndividualService individualService;
	
	public Individual addIndividual(IndividualInput individualInput) {
		
		Individual individual=Individual.builder()
				.customerId(individualInput.getCustomerId())
				.contactNo(individualInput.getContactNo())
				.dob(individualInput.getDob())
				.name(FullName.builder()
						.firstName(individualInput.getName().getFirstName())
						.lastName(individualInput.getName().getLastName())
						.middleName(individualInput.getName().getMiddleName()).build()
						
						)
				.email(individualInput.getEmail())
				.password(individualInput.getPassword())
				.gender(individualInput.getGender())
				.build();
				
		
		return this.individualService.addIndividual(individual);
		
		
	}
	
	  public Individual updateIndividual(long customerId,String email) {
	  
		  return this.updateIndividual(customerId, email);
	  }
	  
	  public boolean deleteIndividual(long customerId){
	  
		  return this.individualService.deleteIndividualById(customerId);
	  }
	 

}
