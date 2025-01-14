package com.main;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.request.Request;
import com.response.Response;

import java.util.HashMap;
import java.util.Map;

import java.util.Base64;

@RestController
public class Controller {

	@PostMapping("/authenticate")
    public ResponseEntity<Map<String, Object>> getItems(@RequestBody Request request) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "GET request received");
        response.put("data",authenticate(request.getUser().getName(),request.getUser().getPassword())); // Empty data for demonstration
        return ResponseEntity.ok(response);
    }
    
    public String authenticate(String userName, String password) {
        String auth = userName + ":" + password;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
    	return encodedAuth;
    }

    // POST endpoint
    @PostMapping("/createUser")
    public Response createItem(@RequestBody Request request) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "POST request received");
        response.put("data", request);
        System.out.println("Request Body: " + request);
        System.out.println("Response Body: " + response);
        return new Response(request.getUser().getName(),request.getUser().getName(),request.getUser().getName());
    }

    // PUT endpoint
    @PutMapping
    public ResponseEntity<Map<String, Object>> updateItem(@RequestBody Request itemRequest) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "PUT request received for item ");
        response.put("data", itemRequest);
        System.out.println("Request Body: " + itemRequest);
        System.out.println("Response Body: " + response);
        return ResponseEntity.ok(response);
    }

    // DELETE endpoint
    @DeleteMapping
    public ResponseEntity<Map<String, Object>> deleteItem( @RequestBody Request itemRequest) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "DELETE request received for item ");
        System.out.println("Request Body: " + itemRequest);
        System.out.println("Response Body: " + response);
        return ResponseEntity.ok(response);
    }
}