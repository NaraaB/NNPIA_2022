package cz.upce.nnpia.springbootdemo;
import java.sql.Date;

public class User {
    private String name;
    private Date birthday;
    private String gender;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public String getGender(){
        return gender;
    }
    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }
    public Date getBirthday(){
        return birthday;
    }
}
