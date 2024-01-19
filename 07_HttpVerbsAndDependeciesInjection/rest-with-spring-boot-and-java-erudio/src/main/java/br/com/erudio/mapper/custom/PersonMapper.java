package br.com.erudio.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.model.Person;

@Service
public class PersonMapper {
	//Converting Person to PersonVOV2
	public PersonVOV2 convertEntityToVo(Person person) {
		
		PersonVOV2 vo = new PersonVOV2();
		vo.setId(person.getId());
		vo.setAddress(person.getAddress());
		vo.setBirthday(new Date());
		vo.setId(person.getId());
		vo.setLastName(person.getLastName());
		vo.setGender(person.getGender());
		
		return vo;
	}
	//Converting PersonVOV2 to Person
	public Person convertVoToEntity(PersonVOV2 person) {

		Person entity = new Person();
		entity.setId(person.getId());
		entity.setAddress(person.getAddress());
		// entity.setBirthday(new Date());
		entity.setId(person.getId());
		entity.setLastName(person.getLastName());
		entity.setGender(person.getGender());

		return entity;
	}
}
