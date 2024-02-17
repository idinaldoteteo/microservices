package com.store.auth.service.impl;

import com.store.auth.domain.Company;
import com.store.auth.repository.CompanyRepository;
import com.store.auth.service.ICompanyService;

public class CompanyService extends GenericService<Company, Long, CompanyRepository> implements ICompanyService{

	public CompanyService(CompanyRepository repository) {
		super(repository);
	}

}
