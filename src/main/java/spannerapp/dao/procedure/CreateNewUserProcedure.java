package spannerapp.dao.procedure;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import spannerapp.model.AuthorizationUser;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Siekacz on 06.06.2017.
 */
public class CreateNewUserProcedure extends StoredProcedure {

    private static final String CREATE_USER = "SP_CREATE_USER";

    public CreateNewUserProcedure(DataSource dataSource){
        super(dataSource, CREATE_USER);

        declareParameter(new SqlParameter("Login", Types.NVARCHAR));
        declareParameter(new SqlParameter("Password", Types.NVARCHAR));
        declareParameter(new SqlParameter("EmployeeID", Types.INTEGER));
        declareParameter(new SqlParameter("RoleID", Types.INTEGER));
        declareParameter(new SqlOutParameter("UserID", Types.INTEGER));

        compile();
    }
    public int execute(AuthorizationUser user){
        Map<String, Object> row = new HashMap<>();

        row.put("Login", user.getUsername());
        row.put("Password", user.getPassword());
        row.put("EmployeeID", user.getEmployee().getEmployeeID());
        row.put("RoleID", user.getRole().getRoleID());

        Map<String, Object> output = execute(row);

        if(output.size() > 0)
            return (Integer) output.get("UserID");
        else
            return -1;
    }
}
