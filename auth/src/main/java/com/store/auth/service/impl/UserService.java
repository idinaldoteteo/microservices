package com.store.auth.service.impl;

import org.springframework.stereotype.Service;

import com.store.auth.domain.User;
import com.store.auth.repository.IUserRepository;
import com.store.auth.service.IUserService;

@Service
public class UserService extends GenericService<User, Long, IUserRepository> implements IUserService{

	public UserService(IUserRepository repository) {
		super(repository);
	}

	
}
