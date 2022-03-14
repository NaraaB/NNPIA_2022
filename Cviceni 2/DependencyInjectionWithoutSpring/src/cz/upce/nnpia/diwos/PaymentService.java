package cz.upce.nnpia.diwos;

public class PaymentService {
    private UserService userService;

    public PaymentService(UserService userService){
        this.userService = userService;
    }
    public void processPayment(){
        //process payment
        userService.updateLog("A new payment has been processed.");
    }
}
