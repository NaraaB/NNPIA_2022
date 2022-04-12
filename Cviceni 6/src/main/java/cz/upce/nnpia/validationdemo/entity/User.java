package cz.upce.nnpia.validationdemo.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private UserTypeEnum type;

    @NotNull
    @Min(value = 1, message = "This field can not be empty!")
    @Column
    private String fullName;

    @Email(message = "Please enter valid e-mail address!")
    @Min(value = 1, message = "This field can not be empty!")
    @Column
    private String email;

    @Size(min = 6, max = 50,
            message = "Password length must be between 6 and 50 characters")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]+)$",
            message = "Password must include at least one digit and one letter!")
    @Column
    private String password;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public UserTypeEnum getType() {
        return type;
    }

    public void setType(UserTypeEnum type) {
        this.type = type;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
