package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class SparePart {
    public String name;
    public int price;
    public List<Repair> repairList;
    public List<Item> itemList;



    public SparePart(String name, int price) {
        this.name = name;
        this.price = price;
        repairList = new ArrayList<Repair>();
        itemList = new ArrayList<Item>();
    }

    public void addRepair(Repair repair){

        if(!repairList.contains(repair) )repairList.add(repair);
    }

    public void addItem(Item item){

        if(!itemList.contains(item)) itemList.add(item);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
