package Connection;
public class UserAirline {
    private int id;
    private String name;   

    public UserAirline(int ID, String Name) {
        this.id = ID;
        this.name = Name;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }
}
