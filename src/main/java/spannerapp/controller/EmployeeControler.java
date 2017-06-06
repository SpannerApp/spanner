package spannerapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import spannerapp.model.Employee;
import spannerapp.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeControler {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> getAllEmployees(){ return employeeService.getAllEmployees();}

    @RequestMapping(method = RequestMethod.GET, value = "/servicemen")
    public List<Employee> getAllServicemen(){ return employeeService.getAllServicemen();}

    @RequestMapping(value = "/insertEmployee", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }


}
