package org.example;

import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private PaymentService p;
    OrderService(PaymentService p){
        this.p=p;
    }

    public void placeorder(){
        p.pay();
        System.out.println("Order placed");
    }
}
