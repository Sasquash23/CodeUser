package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindEmployeeFacde {

    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    @Autowired
    public FindEmployeeFacde(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public List<Company> retrieveCompanyByPartOfName(String part) {
        part = "%" + part + "%";
        return companyDao.retrieveCompanyByPartOfName(part);
    }

    public List<Employee> retrieveEmployeeByPartOfName(String part){
        part = "%" + part + "%";
        return employeeDao.retrieveEmployeeByPartOfName(part);
    }
}
