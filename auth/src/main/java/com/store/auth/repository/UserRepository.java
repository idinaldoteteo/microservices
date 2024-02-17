package com.store.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.auth.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
