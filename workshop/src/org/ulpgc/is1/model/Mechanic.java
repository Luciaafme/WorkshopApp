package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class Mechanic {

    public String name;
    public String surname;

    public List<Repair> repairList;


    public Mechanic(String name, String surname) {
        this.name = name;
        this.surname = surname;
        repairList = new ArrayList<Repair>();
    }

    public void addRepair(Repair repair){
        if(!repairList.contains(repair)) repairList.add(repair);
    }

    public Repair getRepair(int index){
        return repairList.get(index);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
