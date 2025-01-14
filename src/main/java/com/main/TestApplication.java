package com.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.servlet.ServletContext;

@SpringBootApplication
public class TestApplication implements CommandLineRunner  {

	private final ServletContext servletContext;

    public TestApplication(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String baseUrl = String.format("http://localhost:%d", 8080);

        System.out.println("Custom API Endpoints:");
        System.out.println("GET: " + baseUrl + "/api/items");
        System.out.println("POST: " + baseUrl + "/api/items");
        System.out.println("PUT: " + baseUrl + "/api/items/{id}");
        System.out.println("DELETE: " + baseUrl + "/api/items/{id}");
    }

}
