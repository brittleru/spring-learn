//package com.example.employee.service;
//
////import com.example.employee.dao.EmployeeDAO;
//import com.example.employee.dao.EmployeeRepository;
//import com.example.employee.entity.Employee;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class EmployeeServiceImplementation implements EmployeeService {
//
//    private EmployeeRepository employeeRepository;
//
//    @Autowired
//    public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }
//
//    // no need for @Transactional it has it out of the box
//    @Override
//    public List<Employee> findAll() {
//        return employeeRepository.findAll();
//    }
//
//    @Override
//    public Employee findById(int id) {
//        Optional<Employee> result = employeeRepository.findById(id);
//
//        Employee employee = null;
//        if (result.isPresent()) {
//            employee = result.get();
//        }
//        else {
//            throw new RuntimeException("Did not find employee id - " + id);
//        }
//
//        return employee;
//    }
//
//    @Override
//    public void save(Employee employee) {
//        employeeRepository.save(employee);
//    }
//
//    @Override
//    public void deleteById(int id) {
//        employeeRepository.deleteById(id);
//    }
//
//
////    private EmployeeDAO employeeDAO;
////
////    @Autowired
////    public EmployeeServiceImplementation(
////            // need to choose which DAO impl to use, using their bean ID
//////            @Qualifier("employeeDAOHibernateImplementation")
////            @Qualifier("employeeDAOJpaImplementation")
////                EmployeeDAO employeeDAO
////    ) {
////        this.employeeDAO = employeeDAO;
////    }
////
////    @Override
////    @Transactional
////    public List<Employee> findAll() {
////        return employeeDAO.findAll();
////    }
////
////    @Override
////    @Transactional
////    public Employee findById(int id) {
////        return employeeDAO.findById(id);
////    }
////
////    @Override
////    @Transactional
////    public void save(Employee employee) {
////        employeeDAO.save(employee);
////    }
////
////    @Override
////    @Transactional
////    public void deleteById(int id) {
////        employeeDAO.deleteById(id);
////    }
//
//
//}
