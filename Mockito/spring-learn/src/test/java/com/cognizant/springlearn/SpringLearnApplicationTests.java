package com.cognizant.springlearn;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.springlearn.controller.CountryController;
import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class SpringLearnApplicationTests {
	
	@Autowired
	private CountryController countryController;	
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CountryService countryService;
	
	

	@Test
	public void contextLoads() 
	{		
		//CountryController countryController=new CountryController();
		assertNotNull(countryController);
	}	
	
	@Test
	public void testGetCountry() throws Exception 
	{		
		//CountryController countryController=new CountryController();
		Country mockCountry = new Country("IN","India");
		
		Mockito.when(countryService.getCountry(Mockito.anyString())).thenReturn(mockCountry);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/countries/IN").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse().getContentAsString());
		String expected = "{code:IN,name:India}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
	}	
	
	
	
	
//	@Test
//	public void testGetCountry()throws Exception
//	{
//        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get("/country"));
//        actions.andExpect(status().isOk());
//        actions.andExpect(jsonPath("$.code").exists());
//        actions.andExpect(jsonPath("$.code").value("IN"));
//        
//        actions.andExpect(jsonPath("$.name").exists());
//        actions.andExpect(jsonPath("$.name").value("India"));
//	}
	
//	@Test
//	public void testGetCountryException()throws Exception
//	{
//        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get("/countries/az"));
//        actions.andExpect(status().isNotFound());
//        actions.andExpect(status().reason("Country Not Found"));
//
//       
//	}
	
}
