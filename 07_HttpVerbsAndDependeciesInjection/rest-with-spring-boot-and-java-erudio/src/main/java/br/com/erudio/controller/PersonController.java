package br.com.erudio.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.model.Person;
import br.com.erudio.services.PersonServices;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	private PersonServices service;
	// private PersonServices service = new PersonServices();

	@RequestMapping(method = RequestMethod.GET)
	public List<Person> findAll() {

		return service.findAll();
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Person findById(@PathVariable(value = "id") Long id){
		
		return service.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Person create(@RequestBody Person person) {
		
		return service.create(person);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Person update(@RequestBody Person person) {
		
		return service.update(person);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") Long id){
		
		service.delete(id);
	}
}
