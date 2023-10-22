package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    public String name;
    public Phone phone;

    public List<Vehicle> owner;
    public Customer(String name, Phone phone) {
        this.name = name;
        this.phone = phone;
        owner = new ArrayList<Vehicle>();
    }
    public void addVehicle(Vehicle vehicle){

        if (!owner.contains(vehicle)) owner.add(vehicle);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}