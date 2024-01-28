package de.objego.urlshortener.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class UrlShortenerServiceTest {
    // TODO: Implement tests

	
    
    @Autowired 
    UrlShortenerService urlshortnerservice = new   UrlShortenerService ();
    @Test
    void shouldShortenURL() {
     //   fail("Implement me");
       
    	    String input = "https://codesubmit.io/library/react"; 
            String actualResult;
			try {
				actualResult = urlshortnerservice.encodeURL(input);
	            assert actualResult.length() < input.length()  : "ShortenURL is incorrect";

			} catch (Exception e) {
				
				System.out.print(e.getMessage());
			}
            
            
            		
    	}  
    
    @Test
    void invalidurl() {
     //   fail("Implement me");
       
    	    String input = "hamada/codesubmit.io/library/react"; 
            boolean actualResult;
			
				actualResult = urlshortnerservice.isvalidateUrl(input);
	            assertFalse (actualResult) ;

			
            
            		
    	} 
    
    
    
    
    
    }

