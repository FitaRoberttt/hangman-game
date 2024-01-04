package com.example.HangmanApi.service.impl;

import com.example.HangmanApi.model.entity.User;
import com.example.HangmanApi.repository.UserRepository;
import com.example.HangmanApi.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetOrCreateUserByName_ExistingUser() {
        // Arrange
        String existingUserName = "existingUser";
        User existingUser = new User();
        existingUser.setName(existingUserName);

        // Simulăm comportamentul repository-ului pentru a returna un utilizator existent
        when(userRepository.findByName(existingUserName)).thenReturn(existingUser);

        // Act
        User resultUser = userService.getOrCreateUserByName(existingUserName);

        // Assert
        assertNotNull(resultUser);
        assertEquals(existingUser, resultUser);

        // Verificăm că metoda save() nu a fost apelată (pentru că utilizatorul există deja)
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void testGetOrCreateUserByName_NewUser() {
        // Arrange
        String newUserName = "newUser";

        // Simulăm comportamentul repository-ului pentru a returna null (utilizator inexistent)
        when(userRepository.findByName(newUserName)).thenReturn(null);

        // Act
        User resultUser = userService.getOrCreateUserByName(newUserName);

        // Assert
        assertNotNull(resultUser);
        assertEquals(newUserName, resultUser.getName());

        // Verificăm că metoda save() a fost apelată pentru a salva noul utilizator
        verify(userRepository, times(1)).save(any(User.class));
    }
}
