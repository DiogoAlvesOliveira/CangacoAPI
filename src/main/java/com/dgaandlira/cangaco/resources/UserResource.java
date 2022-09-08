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

    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<User> findByCPF(@PathVariable String cpf) {
        User user = userService.findByCPF(cpf);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findByID(@PathVariable Integer id){
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }
}
