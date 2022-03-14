package cz.upce.nnpia.diws.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    UserService userService;
    public void registerBooking(){
        //register the booking
        userService.updateLog("A booking request has been registered.");
    }
}
