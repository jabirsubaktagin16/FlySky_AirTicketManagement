package Connection;

public class User2 {

    private int id;
    private String name;
    private String employeetype;
    private String email;
    private String phone;    

    public User2(int ID, String Name,String EmployeeType, String Email, String Phone) {
        this.id = ID;
        this.name = Name;
        this.employeetype=EmployeeType;
        this.email = Email;
        this.phone = Phone;

    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public String getEmployeeType()
    {
        return employeetype;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

}
