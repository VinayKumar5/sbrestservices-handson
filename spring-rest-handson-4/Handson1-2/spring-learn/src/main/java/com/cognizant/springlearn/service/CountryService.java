package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {
	
	public Country getCountry(String code)throws CountryNotFoundException
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> countries = (ArrayList<Country>)context.getBean("countryList", java.util.ArrayList.class);
		
//		final Country c=null;		
//		countries.forEach((country)-> {
//										if(country.getCode().equalsIgnoreCase(code))
//										{
//											c=country;																					
//										}										
//											//System.out.println(country);
//										});
		
		if(!countries.isEmpty())
		{
			for(Country c:countries)
			{
				if(c.getCode().equalsIgnoreCase(code))
					return c;
			}			
		}		
		
		throw new CountryNotFoundException();	
	}

}
