package com.request;

public class Request {
    private User user;

    // Getters and Setters
    public User getUser () {
        return user;
    }

    public void setUser (User user) {
        this.user = user;
    }

    public static class User {
        private String name;
        private String email;
        private String password;

        // Getters and Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
    }
}