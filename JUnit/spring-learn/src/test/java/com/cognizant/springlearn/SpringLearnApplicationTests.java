package com.cognizant.springlearn;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;



//@SpringBootTest
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class SpringLearnApplicationTests {

	 @LocalServerPort
	    int randomServerPort;
	     
	    @Test
	    public void testSayHello() throws URISyntaxException 
	    {
	    	
	    	RestTemplate restTemplate = new RestTemplate();
	        
	        final String baseUrl = "http://localhost:" + randomServerPort + "/hello";
	        URI uri = new URI(baseUrl);
	     
	        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	         
	        //Verify request succeed
	        Assert.assertEquals(200, result.getStatusCodeValue());
	        Assert.assertEquals(true, result.getBody().contains("Hello"));
	 
	    }  

}
