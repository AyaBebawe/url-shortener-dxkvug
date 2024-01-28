package de.objego.urlshortener.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestBody;

import de.objego.urlshortener.model.inputUrl;
import de.objego.urlshortener.model.outputurl;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

@WebMvcTest
class UrlShortenerControllerTest {

    // TODO: Implement tests
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    UrlShortenerController shortnercontroller ;
    @Test
    void checkThat2DifferentURLsShortenToDifferentShortURL() {
    
    	inputUrl inputurl1 = new inputUrl()  ;
    	inputurl1.inputurl = "https://codesubmit.io/library/react";
    	
    	inputUrl inputurl2= new inputUrl()  ;
    	inputurl2.inputurl = "https://codereview.io/record" ;
    	 
    	String outputurl1 =shortnercontroller.encodeURL (inputurl1).getBody().outurl;
    	String outputurl2 =shortnercontroller.encodeURL (inputurl2).getBody().outurl;

    	assertNotEquals(outputurl1, outputurl2);
    	
    }
}
