package org.example.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.example.entity.User;
import org.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    public ResponseEntity<List<User>> getUsers() {
        logger.info("success getUsers");

        List<User> users = userService.getUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/{Id}")
    public ResponseEntity<Object> getUserById(@PathVariable(name = "Id") Long id) {
        logger.info("get id by {}", id);
        User user = userService.getById(id);
        if (user==null) {
            return new ResponseEntity<>("user not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> create(@RequestBody User user) {
        logger.info("create {}", user.getId());

        User user1 = userService.save(user);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }

    @PatchMapping(value = "/{Id}")
    public ResponseEntity<Object> updateUser(@PathVariable("Id") Long id, @RequestBody Map<String, Object> payload) {
        // @RequestBody Map<String, Object> payload
        // @RequestBody JsonNode jsonNode
        User user = userService.getById(id);
        if (user==null) return ResponseEntity.notFound().build();
        for (String key : payload.keySet()) {
            switch (key) {
                case "password" -> user.setPassword((String) payload.get(key));
                case "first_name" -> user.setFirst_name((String) payload.get(key));
                case "last_name" -> user.setLast_name((String) payload.get(key));
                case "profile" -> user.setProfile((String) payload.get(key));
                case "email" -> user.setEmail((String) payload.get(key));
                case "address" -> user.setAddress((String) payload.get(key));
                default -> {
                    return new ResponseEntity<>("invalid parameter: " + key, HttpStatus.FORBIDDEN);
                }
            };
        }
        userService.update(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{Id}")
    public ResponseEntity delete(@PathVariable(name = "Id") Long id) {
        if (userService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
