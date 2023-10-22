package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class RepairManager {

    private List<Mechanic> mechanicList;
    private List<Vehicle> vehicleList;

    private List<SparePart> sparePartList;

    public RepairManager() {
        mechanicList = new ArrayList<Mechanic>();
        vehicleList = new ArrayList<Vehicle>();
        sparePartList = new ArrayList<SparePart>();
    }

    public void addSparePart(String name, int price){
        SparePart sparePart = new SparePart(name, price);
        if(!sparePartList.contains(sparePart)) sparePartList.add(sparePart);
    }
    public List<SparePart> getSparePart(){
        return sparePartList;
    }

    public void addMechanic(String name, String surname){
        Mechanic mechanic = new Mechanic(name, surname);
        if(!mechanicList.contains(mechanic)) mechanicList.add(mechanic);
    }
    public void addVehicle(String make, String model, Plate plate){
        Vehicle vehicle = new Vehicle(make, model, plate);
        if(!vehicleList.contains(vehicle))vehicleList.add(vehicle);
    }


    public Mechanic getMechanic(int index){

        return mechanicList.get(index);
    }

    public Vehicle getVehicle(int index){

        return vehicleList.get(index);
    }

    public int countVehicle(){

        return vehicleList.size();
    }


    public void repair(Vehicle vehicle, Mechanic mechanic, Date date, String description, int effort, BreakdownTypes breakdownType, List<SparePart> sparePart,  List<Item> itemList) {

        Repair repair = new Repair(date, description, effort, breakdownType);
        mechanic.addRepair(repair);
        repair.addMechanic(mechanic);

        vehicle.addRepair(repair);
        repair.addVehicle(vehicle);


        for(int i=0; i<sparePart.size();i++){
            sparePart.get(i).addRepair(repair);
            repair.addSparePart(sparePart.get(i));
            itemList.get(i).setSparePart(sparePart.get(i));
            sparePart.get(i).addItem(itemList.get(i));
            repair.addItem(itemList.get(i));
        }

    }


    public void removeVehicle(int index){

        vehicleList.remove(index);
    }

}