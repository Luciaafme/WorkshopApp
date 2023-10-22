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

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Plate getPlate() {
        return plate;
    }

    public void setPlate(Plate plate) {
        this.plate = plate;
    }

    public void addRepair(Repair repair){

        if(!repairList.contains(repair))repairList.add(repair);
    }

    public void addCustomer(Customer customer){
        this.customer = customer;
    }
}
