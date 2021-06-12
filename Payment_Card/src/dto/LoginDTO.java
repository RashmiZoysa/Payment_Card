package dto;

public class LoginDTO {
    private String Name;
    private String password;
    private String Designation;

    public LoginDTO(String username, String password) {
    }

    public LoginDTO(String name, String password, String designation) {
        Name = name;
        this.password = password;
        Designation = designation;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }
}
