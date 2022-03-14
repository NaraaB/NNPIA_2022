package cz.upce.nnpia.diws.demo;

import cz.upce.nnpia.diws.demo.service.BookingService;
import cz.upce.nnpia.diws.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DemoApplication {
    @Autowired
    BookingService bookingService;

    @Autowired
    PaymentService paymentService;
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                "cz.upce.nnpia.diws.demo"
        );
        context.getBean(DemoApplication.class).process();
    }

    private void process() {
        bookingService.registerBooking();
        paymentService.processPayment();
    }

}
