package com.andredupont.DcUniverse;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log
@SpringBootApplication
public class DcUniverseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DcUniverseApplication.class, args);
		log.info("Dupont");
	}

}
