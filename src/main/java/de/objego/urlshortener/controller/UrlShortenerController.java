package de.objego.urlshortener.controller;

import de.objego.urlshortener.model.inputUrl;
import de.objego.urlshortener.model.outputurl;
import de.objego.urlshortener.service.UrlShortenerService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor

@RequestMapping("/")
public class UrlShortenerController {
	
	
    private final UrlShortenerService shortenerService = new UrlShortenerService () ;
    
   
	@PostMapping (value = "encode" , produces=MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<outputurl> encodeURL(@RequestBody inputUrl longurl) 
	{
		outputurl outurl = new outputurl();
		try 
		{
		
		outurl.outurl =shortenerService.encodeURL(longurl.inputurl) ;
		
		return  new ResponseEntity <>(outurl,HttpStatus.OK)  ;
	
		}
	
		catch (Exception e)
		{
			outurl.outurl = "Invalid input URL";
			return  new ResponseEntity <>(outurl,HttpStatus.EXPECTATION_FAILED)  ;
		}
	}	

    // TODO: Implement the REST endpoints here
    
	@PostMapping (value="decode" , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<outputurl> decodeURL(@RequestBody inputUrl shorturl)
	{
		outputurl outurl = new outputurl();
		outurl.outurl =shortenerService.DecodeURL(shorturl.inputurl);
		
		
		return new ResponseEntity <>(outurl,HttpStatus.OK)  ;
	}
    
    
}
