package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FindEmployeeFacdeTest {
    @Autowired
    private FindEmployeeFacde findEmployeeFacde;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    private Employee johnSmith = null;
    private Employee stephanieClarckson = null;
    private Company dataMasters = null;
    private Company greyMatter = null;

    @Before
    public void setUp() throws Exception {
        johnSmith = new Employee("John", "Smith");
        stephanieClarckson = new Employee("Stephanie", "Clarckson");
        dataMasters = new Company("Data Masters");
        greyMatter = new Company("Grey Matter");
    }

    @After
    public void tearDown() throws Exception {
        companyDao.delete(dataMasters);
        companyDao.delete(greyMatter);
        employeeDao.delete(johnSmith);
        employeeDao.delete(stephanieClarckson);
    }

    @Test
    public void retrieveCompanyNameLikeTest() {
        //Given
        greyMatter.getEmployees().add(johnSmith);
        johnSmith.getCompanies().add(greyMatter);
        companyDao.save(greyMatter);

        // When
        List<Company> foundCompany = findEmployeeFacde.retrieveCompanyByPartOfName("rey");

        //Then
        Assert.assertEquals(greyMatter.getName(), foundCompany.get(0).getName());
    }

    @Test
    public void ShouldFindEmployeebyPartOfName() {
        //Given
        employeeDao.save(johnSmith);

        // When
        List<Employee> actualEmployee = findEmployeeFacde.retrieveEmployeeByPartOfName("mit");

        //Then
        Assert.assertEquals(johnSmith.getLastname(), actualEmployee.get(0).getLastname());
    }
}