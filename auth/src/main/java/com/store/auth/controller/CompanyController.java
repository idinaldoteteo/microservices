package com.store.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.auth.domain.Company;
import com.store.auth.service.ICompanyService;

@RestController
@RequestMapping("/api/company")
public class CompanyController extends GenericController<Company>{
	
    public CompanyController(ICompanyService service){ super(service); }
    
}