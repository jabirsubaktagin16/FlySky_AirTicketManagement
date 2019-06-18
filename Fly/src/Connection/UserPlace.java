package Connection;
public class UserPlace {
    private int id;
    private String name;
    private String country;

    public UserPlace(int ID, String Name,String Country) {
        this.id = ID;
        this.name = Name;
        this.country=Country;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getCountry()
    {
        return country;
    }
}
