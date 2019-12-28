package com.company;

import java.util.Date;

public class Payment {
    Date expiration_date=null;
    String card_holder_name=null;
    String security_number=null;
    String card_number=null;
    String password=null;
    String zip_code=null;
    String address=null;
    String email=null;
    String type=null;


    public boolean payForService(double ammount){
        if(processTransaction(ammount)){
            System.out.println("process succesfully done");
            return true;
        }
        System.out.println("error with payment");
        return false;
    }

    private boolean processTransaction(double ammount) {
        //third party code here
        return true;
    }

    public Payment(String card_number, String card_holder_name
            , String security_number, Date expiration_date, String zip_code, String address) {
        this.card_number = card_number;
        this.card_holder_name = card_holder_name;
        this.security_number = security_number;
        this.expiration_date = expiration_date;
        this.zip_code = zip_code;
        this.address = address;
        this.type = "Credit Card";
    }

    public Payment(String email, String password) {
        this.email = email;
        this.password = password;
        this.type = "PayPal";
    }

    public String getType() {
        return type;
    }

}
