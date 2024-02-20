package com.store.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.auth.domain.User;
import com.store.auth.service.IUserService;

@RestController	
@RequestMapping("/api/user")
public class UserController extends GenericController<User>{
	
    public UserController(IUserService service){ super(service); }
    
}