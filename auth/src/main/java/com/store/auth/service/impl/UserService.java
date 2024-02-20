package com.store.auth.service.impl;

import org.springframework.stereotype.Service;

import com.store.auth.domain.User;
import com.store.auth.repository.UserRepository;
import com.store.auth.service.IUserService;

@Service
public class UserService extends GenericService<User, Long, UserRepository> implements IUserService{

	public UserService(UserRepository repository) {
		super(repository);
	}

	
}
