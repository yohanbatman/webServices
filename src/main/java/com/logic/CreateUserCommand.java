package com.logic;


//import com.example.cayenneintegration.generated.User; // Import the generated User class
import org.apache.cayenne.ObjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.request.Request.User;

@Service
public class CreateUserCommand {

    @Autowired
    private ObjectContext objectContext;

    public void createUser (String name, int age) {
        User user = objectContext.newObject(User.class);
        user.setName(name);
        objectContext.commitChanges();
    }
}

