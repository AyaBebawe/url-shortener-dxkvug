package de.objego.urlshortener.service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class UrlShortenerService {
	
	
	HashMap <String,String> map = new  HashMap <String,String>();
	
	public String encodeURL(String longurl) throws Exception{
		
		if (isvalidateUrl(longurl))
		{
		StringBuilder shorturl  = new  StringBuilder();
		
		String[] split = longurl.split("//");
		String prefex = split [0] ;
		shorturl.append(prefex).append("//short.est/"); 
		shorturl.append(split[1].hashCode()) ;
				
		if (shorturl.length()  >= longurl.length() )
		{
			shorturl.substring(0, shorturl.length()-longurl.length() ) ;
		}
			
		//add into hashmap 
		map.put(shorturl.toString(), longurl);
		return shorturl.toString() ;
		}
		
		else {
			throw new Exception() ;
		}
		
	}
	
	
	public boolean isvalidateUrl (String url) { 
	    try {
	        new URL(url).toURI();
	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	
	
public String DecodeURL(String shorturl){
		
		
	// retrieve from Hashmap with key equals shorturl 
		String longurl = map.get(shorturl);
		
		return longurl ;
		
		
	}
	
}
