package com.spring.mvc.service;

import com.spring.mvc.dao.UserImpl;
import com.spring.mvc.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserTest {

    @Mock
    UserService userService;

    @BeforeAll
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldBeCorrectGetUserMethod() {
        User user = new UserImpl("Nick", 1L, "Noick@gmail.com");

        when(userService.getUser("Nick")).thenReturn(user);

        assertEquals(userService.getUser("Nick"), user);
    }

    @Test
    public void shouldBeNullInsteadUser() {

        when(userService.getUser("Nick")).thenReturn(null);

        assertNull(userService.getUser("Nick"));
    }

    @Test
    public void shouldBeIncorrectUser() {
        User user = new UserImpl("Nick", 1L, "Noick@gmail.com");

        when(userService.getUser("Nick")).thenReturn(user);

        assertNotEquals(userService.getUser("Tin"), user);
    }
}
