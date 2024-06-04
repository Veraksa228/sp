package ru.kata.spring.boot_security.demo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.UserRepository;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userServiceImpl;


    @Test
    void testFindByEmail() {
        User expectedUser = new User("user", "user", "user@user.ru", (byte) 26, "user", "user");
        Mockito.when(userRepository.findByEmail("user@user.ru")).thenReturn(Optional.of(expectedUser));
        User foundUser = userServiceImpl.findByEmail("user@user.ru").get();
        Assertions.assertEquals(expectedUser, foundUser);
    }
}
