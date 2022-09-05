package com.dgaandlira.cangaco.resources;

import com.dgaandlira.cangaco.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Test {

    @Autowired
    private TestService testService;

    @GetMapping(value = "/test")
    public String test() {
        return testService.test();
    }
}
