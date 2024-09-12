package com.ndanh.learn.springaop.biz;

import org.springframework.stereotype.Component;
@Component
public class ShoppingCart {
    public void checkOut(){
        System.out.println("Checkout ");
    }

    public void checkOutWithParam(String param){
        System.out.println("checkOutWithParam " + param);
    }

    public String quantity(){
        return "2";
    }
}
