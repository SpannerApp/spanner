package spannerapp.model;

/**
 * Created by MATI on 26.04.2017.
 */
public class Machine {
    private Integer id;
    private String code;
    private String name;
    private String model;
    private String section;
    private String colour;
    private String lastRepair;
    private Employee lastServiceman;
    private String description;

    public Machine(Integer id, String code, String name, String model, String section, String colour, String lastRepair, Employee lastServiceman, String description) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.model = model;
        this.section = section;
        this.colour = colour;
        this.lastRepair = lastRepair;
        this.lastServiceman = lastServiceman;
        this.description = description;
    }

    public Machine(){};

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getLastRepair() {
        return lastRepair;
    }

    public void setLastRepair(String lastRepair) {
        this.lastRepair = lastRepair;
    }

    public Employee getLastServiceman() {
        return lastServiceman;
    }

    public void setLastServiceman(Employee lastServiceman) {
        this.lastServiceman = lastServiceman;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
