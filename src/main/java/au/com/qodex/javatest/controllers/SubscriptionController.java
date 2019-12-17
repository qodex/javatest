package au.com.qodex.javatest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import au.com.qodex.javatest.utils.Truncator;

@RestController
public class SubscriptionController {

    @Autowired
    Truncator trunc;

    public SubscriptionController() {
        System.out.println("subscription controller started....");
    }

    @GetMapping(value = "/subscribe/{orderDetails}")
    public String subscribe(@PathVariable String orderDetails) {
        // String orderDetails = getOrderDetails(request);
        String truncatedOrderDetails = trunc.truncate(orderDetails, 250);
        log(truncatedOrderDetails);
        return truncatedOrderDetails;
    }

    private void log(String log) {
        System.out.println(this.getClass().getCanonicalName()+": "+log);
    }
}
