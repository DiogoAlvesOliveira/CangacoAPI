package com.dgaandlira.cangaco.resources;

import com.dgaandlira.cangaco.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/test")
    public String test() {
        return userService.test();
    }
}
