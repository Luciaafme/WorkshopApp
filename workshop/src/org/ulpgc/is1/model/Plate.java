package org.ulpgc.is1.model;

public class Plate {
    public String number;

    public Plate(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isValid(){
        String plate = number.replaceAll("[\\s-]+", "");
        if(plate.matches("^\\d{4}[A-Z]{3}$")){
            return true;
        }
        else{
            this.number = "XXXX";
            return false;
        }
    }
}

