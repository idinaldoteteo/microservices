package com.store.auth.service.impl;

import org.springframework.stereotype.Service;

import com.store.auth.domain.Company;
import com.store.auth.repository.CompanyRepository;
import com.store.auth.service.ICompanyService;

@Service
public class CompanyService extends GenericService<Company, Long, CompanyRepository> implements ICompanyService{

	public CompanyService(CompanyRepository repository) {
		super(repository);
	}

}
