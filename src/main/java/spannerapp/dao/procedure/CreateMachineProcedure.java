package spannerapp.dao.procedure;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import spannerapp.model.Machine;

import javax.sql.DataSource;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Siekacz on 06.06.2017.
 */
public class CreateMachineProcedure extends StoredProcedure {

    private static final String CREATE_MACHINE = "SP_CREATE_MACHINE";

    public CreateMachineProcedure(DataSource dataSource){
        super(dataSource, CREATE_MACHINE);

        declareParameter(new SqlParameter("Code", Types.NVARCHAR));
        declareParameter(new SqlParameter("Name", Types.NVARCHAR));
        declareParameter(new SqlParameter("Model", Types.NVARCHAR));
        declareParameter(new SqlParameter("Section", Types.NVARCHAR));
        declareParameter(new SqlParameter("Colour", Types.NVARCHAR));
        declareParameter(new SqlParameter("LastRepair", Types.DATE));
        declareParameter(new SqlParameter("LastServicemanID", Types.INTEGER));
        declareParameter(new SqlParameter("Description", Types.NVARCHAR));
        declareParameter(new SqlOutParameter("MachineID", Types.INTEGER));

        compile();
    }

    public int execute(Machine machine){
        Map<String, Object> row = new HashMap<>();
        try {
            row.put("Code", machine.getCode());
            row.put("Name", machine.getName());
            row.put("Model", machine.getModel());
            row.put("Section", machine.getSection());
            row.put("Colour", machine.getColour());
            DateFormat df = new  SimpleDateFormat("dd-MM-yyyy");
            Date date = df.parse(machine.getLastRepair());
            row.put("LastRepair", date);
            row.put("LastServicemanID", machine.getLastServiceman().getEmployeeID());
            row.put("Description", machine.getDescription());

            Map<String, Object> output = execute(row);

            if (output.size() > 0)
                return (Integer) output.get("MachineID");
            else
                return -1;
        } catch (ParseException e){
            return -1;
        }
    }

}
