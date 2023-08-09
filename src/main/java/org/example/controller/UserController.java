package org.example.controller;

import org.example.entity.User;
import org.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> getUsers() {
        logger.info("success getUsers");

        List<User> users = userService.getUsers();

        return users;
    }

    @RequestMapping(value = "/{Id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable(name = "Id") Long id) {
        logger.info("get id by {}", id);
        return userService.getById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void create(@RequestBody User user) {
        logger.info("create {}", user.getId());

        userService.save(user);
    }

    @RequestMapping(value = "/{Id}", method = RequestMethod.PATCH)
    public void updateUser(@PathVariable("Id") Long id, @RequestBody User user) {
        System.out.println(id);
        System.out.println(user);

//        userService.update(user);
    }

    @RequestMapping(value = "/{Id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(name = "Id") Long id) {
        userService.delete(id);
    }
}
