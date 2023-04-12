package annotations.both;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"password", "role"/*, "address"*/})
public class User {
    private String phone;
    private String username;
    // @JsonIgnore(value = true)
    private String password;
    // @JsonIgnore(value = true)
    private String role;
    private Address address;

    public User(String phone, String username, String password, String role, Address address) {
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.role = role;
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "User{" +
                "phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public Address getAddress() {
        return address;
    }
}
