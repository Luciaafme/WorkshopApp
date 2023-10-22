package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Repair {
    private static int NEXT_ID = 0;
    public final int id;
    public Date date;
    public String description;
    public int effort;
    public Payment payment;

    public Vehicle vehicle;
    public List<Mechanic> mechanicList;

    public List<SparePart> sparePartsList;

    public List<Item> itemList;
    public List<BreakdownTypes> breakdownTypeList = new ArrayList<BreakdownTypes>(2);

    public Repair(Date date, String description, int effort, BreakdownTypes breakdownType) {
        this.id = NEXT_ID++;
        this.date = date;
        this.description = description;
        this.effort = effort;
        mechanicList = new ArrayList<Mechanic>();
        sparePartsList = new ArrayList<SparePart>();
        itemList = new ArrayList<Item>();
        breakdownTypeList.add(breakdownType);
    }

    public void addSecondBreakdownType(BreakdownTypes breakdownType){

        if(!breakdownTypeList.contains(breakdownType)) breakdownTypeList.add(breakdownType);
    }
    public void addMechanic(Mechanic mechanic){

        if(!mechanicList.contains(mechanic)) mechanicList.add(mechanic);
    }

    public void addVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public void addSparePart(SparePart sparePart){

        if(!sparePartsList.contains(sparePart)) sparePartsList.add(sparePart);
    }

    public void addItem(Item item){

        if(!itemList.contains(item)) itemList.add(item);
    }

    public void addBreakdownType(BreakdownTypes breakdownType){

        if(!breakdownTypeList.contains(breakdownType)) breakdownTypeList.add(breakdownType);
    }

    public String getBreakdownType() {
        if(breakdownTypeList.size() < 2){
            return breakdownTypeList.get(0).toString();
        }
        else{
            return  breakdownTypeList.get(0).toString() +" and " + breakdownTypeList.get(1).toString();
        }

    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEffort() {
        return effort;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }

    public int price(){
        int amount = 0;
        for(int i = 0; i < itemList.size(); i++){
            amount += sparePartsList.get(i).getPrice() * itemList.get(i).getQuantity();
        }
        this.payment = new Payment(date, amount);
        return amount;
    }
}
