package org.ulpgc.is1.model;

public class Phone {
    public String number;

    public Phone(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isValid(){
        String PhoneNumber = number.replaceAll("[\\s-]+", "");
        if(PhoneNumber.matches("\\d{9}")){
            return true;
        }
        else{
            this.number = "XXXX";
            return false;
        }
    }
}