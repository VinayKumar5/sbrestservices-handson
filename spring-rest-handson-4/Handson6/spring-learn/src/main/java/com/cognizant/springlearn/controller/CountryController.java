package com.cognizant.springlearn.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;

@RestController
public class CountryController {
	
private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

@Autowired
private CountryService countryService;

		@PostMapping(path="/country")
		public Country addCountry(@RequestBody @Valid Country country)
		{
			LOGGER.info("Start");
			LOGGER.info("In addCountry()");
		//	LOGGER.debug("Request Country -{}", country);   
			return country;
		}





/*
	
	@GetMapping(path="/countries/{code}")
	public Country getCountry(@PathVariable String code)throws CountryNotFoundException
	{
		LOGGER.info("Start");
		Country country=countryService.getCountry(code);
		LOGGER.debug("Country- {}", country);
		LOGGER.info("End");	
		return country;
	}
	
	
	@RequestMapping(path="/country", method=RequestMethod.GET)	
	public Country getCountryIndia()
	{
		LOGGER.info("Start");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country)context.getBean("country", com.cognizant.springlearn.Country.class);
		LOGGER.debug("Country- {}", country);
		context.close();
		LOGGER.info("End");		
		return country;				
	}
	
	@GetMapping(path="/countries")
	public ArrayList<Country> getAllCountries()
	{
		LOGGER.info("Start");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> countries = (ArrayList<Country>)context.getBean("countryList", java.util.ArrayList.class);
		LOGGER.debug("Countries- {}", countries);
		context.close();
		LOGGER.info("End");
		return countries;		
	}
*/
}
