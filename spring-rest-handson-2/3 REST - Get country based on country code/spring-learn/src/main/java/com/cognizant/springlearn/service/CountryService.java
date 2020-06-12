package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;

@Service
public class CountryService {
	
	public Country getCountry(String code)
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
		
		for(Country c:countries)
		{
			if(c.getCode().equalsIgnoreCase(code))
				return c;
		}
		
		return null;
	}

}
