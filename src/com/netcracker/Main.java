package com.netcracker;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringJDBCConfiguration.class);

        BuyerDAO buyerDAO = context.getBean(BuyerDAO.class);

        Buyer buyer = new Buyer();
        buyer.setId(3);
        buyer.setName("justadded");
        buyer.setLocation("loc");
        buyer.setDiscount(1337);

        buyerDAO.add(buyer);
        System.out.println(buyerDAO.findAll());
        System.out.println(buyerDAO.findById(3));
        System.out.println(buyerDAO.findAll());


    }


}
