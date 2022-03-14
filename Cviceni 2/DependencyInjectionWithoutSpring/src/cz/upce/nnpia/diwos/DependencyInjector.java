package cz.upce.nnpia.diwos;

public class DependencyInjector {
    private static UserService userService;
    private static BookingService bookingService;
    private static PaymentService paymentService;

    public static AccommodationApp getAccommodationApp(){
        return new Application(getBookingService(), getPaymentService());
    }
    private static BookingService getBookingService() {
        if(bookingService == null){
            bookingService = new BookingService(getUserService());
        }
        return bookingService;
    }
    private static PaymentService getPaymentService(){
        if(paymentService == null){
            paymentService = new PaymentService(getUserService());
        }
        return paymentService;
    }
    private static UserService getUserService() {
        if(userService == null){
            userService = new UserService();
        }
        return userService;
    }
}
