package com.dgaandlira.cangaco.resources;

import com.dgaandlira.cangaco.domain.User;
import com.dgaandlira.cangaco.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{cpf}")
    public ResponseEntity<User> findByCPF() {
        User user = userService.findByCPF();
        return ResponseEntity.ok().body(user);
    }
}
