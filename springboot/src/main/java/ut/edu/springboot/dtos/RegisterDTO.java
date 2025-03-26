package ut.edu.springboot.dtos;

import lombok.Data;
@Data
public class RegisterDTO {
    private String username;
    private String password;
    private String role;
    private String email;
    private String phone;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
