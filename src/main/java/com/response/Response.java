package com.response;

public class Response {
    private User user;

    // Constructor
    public Response(String message, String name, String email) {
        this.user = new User(message, name, email);
    }

    // Getters
    public User getUser () {
        return user;
    }

    public static class User {
        private String message;
        private String name;
        private String email;

        // Constructor
        public User(String message, String name, String email) {
            this.message = message;
            this.name = name;
            this.email = email;
        }

        // Getters
        public String getMessage() {
            return message;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }
    }
}