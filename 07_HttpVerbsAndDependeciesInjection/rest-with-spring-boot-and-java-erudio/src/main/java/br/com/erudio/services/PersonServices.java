package br.com.erudio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;

@Service
public class PersonServices {
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	public List<PersonVo> findAll() {
		
		logger.info("Finding all people");	
		
		return repository.findAll();
	}
	
	public PersonVo findById(Long id) {
		
		logger.info("Finding one person!");
	
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No record founds for this ID"));
	}
	
	public PersonVo create (PersonVo person) {
		
		logger.info("Creating one person!");
		
		return repository.save(person);
	}
	
	public PersonVo update (PersonVo person) {
		logger.info("Updating one person!");
		
		PersonVo entity = repository.findById(person.getId()).
			orElseThrow(() -> new ResourceNotFoundException("No record founds for this ID"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(entity);
	}
	
	public void delete (Long id) {
		logger.info("Deleting one person!");
		PersonVo entity = repository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("No record founds for this ID"));
		
		repository.delete(entity);
		
		
	}
	
}
