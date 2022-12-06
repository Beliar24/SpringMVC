package com.spring.mvc.repository;

import com.spring.mvc.model.User;
import com.spring.mvc.storage.Storage;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class UserRepository {

    private Storage storage;

    public void createUser(User user) {
        storage.addToUserStorage(user);
    }

    public User getUser(String name) {
        return storage.getUser(name);
    }
}
