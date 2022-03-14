package cz.upce.nnpia.diws.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    UserService userService;
    public void processPayment(){
        //process payment
        userService.updateLog("A new payment has been processed.");
    }

}
