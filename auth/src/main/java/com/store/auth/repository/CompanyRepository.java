package com.store.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.auth.domain.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

}
