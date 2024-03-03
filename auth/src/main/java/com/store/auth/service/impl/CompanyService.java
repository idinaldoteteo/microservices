package com.store.auth.service.impl;

import org.springframework.stereotype.Service;

import com.store.auth.domain.Company;
import com.store.auth.repository.ICompanyRepository;
import com.store.auth.service.ICompanyService;

@Service
public class CompanyService extends GenericService<Company, Long, ICompanyRepository> implements ICompanyService{

	public CompanyService(ICompanyRepository repository) {
		super(repository);
	}

}
