package cz.upce.nnpia.diws.demo.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public UserService(){

        System.out.println("New instance of UserService");
    }
    public void updateLog(String info){
        System.out.println("User log is updated with the following information: "+info);
    }
}
