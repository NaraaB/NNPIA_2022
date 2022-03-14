package cz.upce.nnpia.diwos;

public class BookingService {
    private UserService userService;
    public BookingService(UserService userService){
        this.userService = userService;
    }
    public void registerBooking(){
        //register the booking
        userService.updateLog("A booking request has been registered.");
    }
}
