package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    public String make;
    public String model;
    public Plate plate;

    public List<Repair> repairList;
    public Customer customer;


    public Vehicle(String make, String model, Plate plate) {
        this.make = make;
        this.model = model;
        this.plate = plate;
        repairList = new ArrayList<Repair>();
    }
}