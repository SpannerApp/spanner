package spannerapp.service;

import spannerapp.model.Employee;

/**
 * Created by Siekacz on 02.06.2017.
 */
public interface IEmployeeService {

    Employee findEmployeeByID(int ID);

}
