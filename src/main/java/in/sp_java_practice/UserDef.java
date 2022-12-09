package in.sp_java_practice;

public class UserDef {
    private String name;
    private Integer id;

    public UserDef(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserDef{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
