package com.sample.springboot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sample.springboot.dao.CountryDao;
import com.sample.springboot.dao.model.Country;

@Controller
public class MyController {
	
	@Autowired
	CountryDao systemRepository;
	
	@Value("${application.message:Hello World}")
	private String message;

	@GetMapping("/")
	public String welcome(Map<String, Object> model) {
		
		String countries="";
		Iterable<Country> systemlist = systemRepository.findAll();
		System.out.println("here are system count: " + systemlist.toString());
		for(Country country:systemlist){
			countries+=country.getName()+" ";
			System.out.println("Here is a system: " + country.toString());
		}
		model.put("message", this.message);
		model.put("countries", countries);
		
		return "Hello";
	}

}