package com.example.dao.employee;

import com.example.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it.. no need to write any code

    // to use spring data REST and get free endpoints we just need this file, entity and the maven dep


    // add a method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();  // this creates a query methods

    // search by name
    public List<Employee> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);
}
