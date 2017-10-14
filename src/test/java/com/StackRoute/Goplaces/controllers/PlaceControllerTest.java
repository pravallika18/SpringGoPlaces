package com.StackRoute.Goplaces.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.StackRoute.Goplaces.MainApp;
import com.StackRoute.Goplaces.domain.Places;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class PlaceControllerTest {
	

    @LocalServerPort

    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();
    Places places;
    

    @Before

    public void setUp() throws Exception {

         places = new Places(5,"dsadas","hsdhsahj","hsahdha");

    }
    private String createURLWithPort(String uri) {

        return "http://localhost:" + port + uri;

    }

	@Test
	public void testAllPlaces() throws Exception{
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(

                createURLWithPort("/v0.1/PlaceSearch/places"),

                HttpMethod.GET, entity, String.class);
System.out.println(response);
        assertNotNull(response);
		
		
	}
	    @Test
	    public void testSaveUser() throws Exception {

	        HttpEntity<Places> entity = new HttpEntity<Places>(places, headers);

	        ResponseEntity<String> response = restTemplate.exchange(

	                createURLWithPort("/v0.1/PlaceSearch/places"),

	                HttpMethod.POST, entity, String.class);

	        assertNotNull(response);
	        System.out.println(response);
	        
	        String actual = response.getBody();

	        System.out.println(actual);

	        assertEquals("Places created successfully",actual);

	    }
	    @Test
	    public void testUpdateUser() throws Exception {

	        HttpEntity<Places> entity = new HttpEntity<Places>(places, headers);

	        ResponseEntity<String> response = restTemplate.exchange(

	                createURLWithPort("/v0.1/PlaceSearch/places"),

	                HttpMethod.PUT, entity, String.class);

	        assertNotNull(response);
	        System.out.println(response);
	        
	        String actual = response.getBody();

	        System.out.println(actual);

	        assertEquals("updated successfully",actual);

	    }
	    @Test
	    public void testDeleteUser() throws Exception {

	        HttpEntity<Places> entity = new HttpEntity<Places>(places, headers);

	        ResponseEntity<String> response = restTemplate.exchange(

	                createURLWithPort("/v0.1/PlaceSearch/places"),

	                HttpMethod.DELETE, entity, String.class);

	        assertNotNull(response);
	        System.out.println(response);
	        
	        String actual = response.getBody();

	        System.out.println(actual);

	        assertEquals("data deleted successfully",actual);

	    }

}
