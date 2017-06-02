package spannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spannerapp.dao.IEmployeeDAO;

/**
 * Created by Siekacz on 25.04.2017.
 */
@Service
public class EmployeeService {

    @Autowired
    private IEmployeeDAO employeeDAO;



}
