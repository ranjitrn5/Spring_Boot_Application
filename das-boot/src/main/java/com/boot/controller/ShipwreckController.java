package com.boot.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.boot.repositories.ShipWreckRepository;

import com.boot.model.Shipwreck;

@RestController
//This would be base url.Its called class level request end point
@RequestMapping("api/v1/")
public class ShipwreckController {
	
	@Autowired
	ShipWreckRepository shipwreckRepository;
	//Method level request mapping annotation. It gets added to the class level request mapping base url
	@RequestMapping(value="shipwrecks", method = RequestMethod.GET)
	public java.util.List<Shipwreck> list(){
		return shipwreckRepository.findAll();
	}
	
	//Handles CRUD operations for Ship Wreck
	@RequestMapping(value="shipwrecks", method = RequestMethod.POST)
	public Shipwreck create(@RequestBody Shipwreck shipwreck){
		return shipwreckRepository.saveAndFlush(shipwreck);
	}
	@RequestMapping(value="shipwrecks/{id}", method = RequestMethod.GET)
	public Shipwreck get(@PathVariable Long id){
		return shipwreckRepository.findOne(id);
	}
	@RequestMapping(value="shipwrecks/{id}", method = RequestMethod.DELETE)
	public Shipwreck delete(@PathVariable Long id){
		Shipwreck existingShipwreck = shipwreckRepository.findOne(id);
		shipwreckRepository.delete(existingShipwreck);
		return existingShipwreck;
	}
	
	@RequestMapping(value="shipwrecks/{id}", method = RequestMethod.PUT)
	public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck){
		Shipwreck existingShipWreck = shipwreckRepository.findOne(id);
		//Copying all the properties in incoming object to the existing ones
		BeanUtils.copyProperties(shipwreck, existingShipWreck);
		
		return shipwreckRepository.saveAndFlush(existingShipWreck);
	}

}
