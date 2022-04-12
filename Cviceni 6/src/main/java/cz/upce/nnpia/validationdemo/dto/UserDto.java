package cz.upce.nnpia.validationdemo.dto;

import cz.upce.nnpia.validationdemo.entity.UserTypeEnum;

public class UserDto {
    private Integer id;
    private String fullName;
    private String email;
    private String password;
    private UserTypeEnum type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public UserTypeEnum getType() {
        return type;
    }

    public void setType(UserTypeEnum type) {
        this.type = type;
    }
}
