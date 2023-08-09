package org.example.service;

import io.jsonwebtoken.Claims;
import org.example.ApplicationBootstrap;
import org.example.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = ApplicationBootstrap.class)
public class JWTServiceTest {
    @Autowired
    private JWTService jwtService;

    @Test
    public void generateTokenTest() {
        User user = new User();
        user.setId(1);
        user.setFirst_name("Xiao");

        String token = jwtService.generateToken(user);

        String[] array = token.split("\\.");
        boolean bool = array.length == 3 ? true: false;
        assertTrue(bool);
    }

    @Test
    public void decryptTokenTest() {
        User user = new User();
        user.setId(1L);
        user.setFirst_name("Xiao");

        String token = jwtService.generateToken(user);

        Claims claims = jwtService.decryptToken(token);
        String firstName = claims.getSubject();

        assertEquals(user.getFirst_name(), firstName);
    }
}
