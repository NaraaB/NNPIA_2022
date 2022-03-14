package cz.upce.nnpia.diwos;

public class Application implements AccommodationApp{
    BookingService bookingService;
    PaymentService paymentService;
    public Application(BookingService bookingService, PaymentService paymentService){
        this.bookingService = bookingService;
        this.paymentService = paymentService;
    }
    public static void main(String[] args) {
        AccommodationApp application = DependencyInjector.getAccommodationApp();
        application.process();
    }
    @Override
    public void process(){
        bookingService.registerBooking();
        paymentService.processPayment();
    }
}
