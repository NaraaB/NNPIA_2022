package cz.upce.nnpia.diwos;

public class UserService {
    public UserService(){
        System.out.println("New instance of UserService");
    }
    public void updateLog(String info){
        System.out.println("User log is updated with the following information: "+info);
    }
}
