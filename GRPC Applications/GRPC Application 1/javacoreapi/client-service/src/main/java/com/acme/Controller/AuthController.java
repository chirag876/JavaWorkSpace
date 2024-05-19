package com.acme.Controller;

import com.acme.Service.AuthService;
import com.google.protobuf.Descriptors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class AuthController {

    private final AuthService service;

    @GetMapping("/user/{id}")
    public Map<Descriptors.FieldDescriptor, Object> getUser(@PathVariable String id) {
        return service.getUser(id);
    }
}
