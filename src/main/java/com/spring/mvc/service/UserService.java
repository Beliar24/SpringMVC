package com.spring.mvc.service;

import com.spring.mvc.model.User;
import com.spring.mvc.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Setter
@Component
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public void createUser(User user){
        userRepository.createUser(user);
    }

    public User getUser(String name) {
        return userRepository.getUser(name);
    }
}
