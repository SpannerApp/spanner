package spannerapp.model;

/**
 * Created by MATI on 26.04.2017.
 */
public class Machine {
    private Integer id;
    private String code;
    private String name;
    private String model;
    private String Section;
    private String colour;
    private String lastrepair;
    private String lastserviceman;

    public Machine(Integer id, String code, String name, String model, String section, String colour, String lastrepair, String lastserviceman) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.model = model;
        Section = section;
        this.colour = colour;
        this.lastrepair = lastrepair;
        this.lastserviceman = lastserviceman;
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
        return Section;
    }

    public void setSection(String section) {
        Section = section;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getLastrepair() {
        return lastrepair;
    }

    public void setLastrepair(String lastrepair) {
        this.lastrepair = lastrepair;
    }

    public String getLastserviceman() {
        return lastserviceman;
    }

    public void setLastserviceman(String lastserviceman) {
        this.lastserviceman = lastserviceman;
    }
}
