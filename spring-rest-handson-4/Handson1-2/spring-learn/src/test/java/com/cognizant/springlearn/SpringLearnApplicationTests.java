package com.cognizant.springlearn;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.cognizant.springlearn.controller.CountryController;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class SpringLearnApplicationTests {
	
	@Autowired
	private CountryController countryController;	
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void contextLoads() 
	{		
		//CountryController countryController=new CountryController();
		assertNotNull(countryController);
	}	
	
	@Test
	public void testGetCountry()throws Exception
	{
        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get("/country"));
        actions.andExpect(status().isOk());
        actions.andExpect(jsonPath("$.code").exists());
        actions.andExpect(jsonPath("$.code").value("IN"));
        
        actions.andExpect(jsonPath("$.name").exists());
        actions.andExpect(jsonPath("$.name").value("India"));
	}
	
	@Test
	public void testGetCountryException()throws Exception
	{
        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get("/countries/az"));
        actions.andExpect(status().isNotFound());
        actions.andExpect(status().reason("Country Not Found"));

       
	}
	
}
