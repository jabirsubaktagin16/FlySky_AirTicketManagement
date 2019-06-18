package Connection;

public class User {

    private int id;
    private String name;
    private String email;
    private String phone;    

    public User(int ID, String Name, String Email, String Phone) {
        this.id = ID;
        this.name = Name;
        this.email = Email;
        this.phone = Phone;

    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

}
