package org.example.controller;

import org.example.service.UserRelationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "")
public class UserRelationController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRelationService userRelationService;

//    @RequestMapping(value = "", method = RequestMethod.POST)
//    public void create()
}
