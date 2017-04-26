package spannerapp.dao.procedure;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import spannerapp.model.Employee;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Siekacz on 26.04.2017.
 */
public class CreateEmployeeProcedure extends StoredProcedure {

    private static final String CREATE_EMPLOYEE = "SP_CREATE_EMPLOYEE";

    public CreateEmployeeProcedure(DataSource dataSource){
        super(dataSource, CREATE_EMPLOYEE);

        declareParameter(new SqlParameter("Name", Types.NVARCHAR));
        declareParameter(new SqlParameter("Surname", Types.NVARCHAR));
        declareParameter(new SqlParameter("PositionID", Types.INTEGER));
        declareParameter(new SqlParameter("SupervisorID", Types.INTEGER));
        declareParameter(new SqlParameter("Address", Types.NVARCHAR));
        declareParameter(new SqlParameter("Phone", Types.NVARCHAR));
        declareParameter(new SqlParameter("Mail", Types.NVARCHAR));

        compile();
    }
     public int execute(Employee employee){
         Map<String, Object> row = new HashMap<>();

         row.put("Name", employee.getName());
         row.put("Surname", employee.getSurname());
         row.put("PositionID", employee.getPositionID());
         row.put("SupervisorID", employee.getSupervisorID());
         row.put("Address", employee.getAddress());
         row.put("Phone", employee.getPhone());
         row.put("Mail", employee.getMail());

         Map<String, Object> output = execute(row);

         if(output.size() > 0)
             return (Integer) output.get("NewID");
         else
             return -1;
     }
}
