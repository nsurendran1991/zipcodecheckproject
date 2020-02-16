package com.zipcodecheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ZipCodeApplication implements CommandLineRunner{

	@Autowired 
	ZipCodeFinder zipCodeFinder;
	 
	public static void main(String[] args) {
		new SpringApplicationBuilder(ZipCodeApplication.class).web(WebApplicationType.NONE).run(args);
	}

	
	 @Override
	    public void run(String... args) throws Exception {
			zipCodeFinder.findZipCodeRestrictions(args);
	    }
}
