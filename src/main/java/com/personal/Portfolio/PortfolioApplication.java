package com.personal.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * <h1>Portfolio Application entry point!</h1>
 * Application which serves as the backend to my website.
 * Fetches data from MongoDB collection, and renders it to the UI.
 * @author  Subham Saha
 * @version 1.0
 * @since   2024-07-03
 */

@SpringBootApplication
public class PortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}

}
