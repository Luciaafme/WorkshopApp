package org.ulpgc.is1.control;

import org.ulpgc.is1.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void init(RepairManager repairManager){
        // Crear perfil de dos mecánicos
        repairManager.addMechanic("Lucía","Afonso Medina");
        repairManager.addMechanic("Alejandro", "Alemán Alemán");

        // Crear dos vehículos con sus respectivos clientes.
        // Hacemos uso del método isValic() para comprobar si es correcta la matrícula y número teléfono
        Plate plate1 = new Plate("1873MLN");
        plate1.isValid();
        Plate plate2 = new Plate("8967LAM");
        plate2.isValid();
        repairManager.addVehicle("Toyota", "Yaris", plate1);
        repairManager.addVehicle("Renault", "Scenic", plate2);

        Phone phone1 = new Phone("632094081");
        phone1.isValid();
        Phone phone2 =  new Phone("679456732");
        phone2.isValid();
        Customer customer1 = new Customer("Joel", phone1);
        Customer customer2 = new Customer("Diego", phone2);

        // Vincular vehículo a su respectivo propietario.
        repairManager.getVehicle(0).addCustomer(customer1);
        repairManager.getVehicle(1).addCustomer(customer2);

        customer1.addVehicle(repairManager.getVehicle(0));
        customer2.addVehicle(repairManager.getVehicle(1));

        // Crear dos piezas en el stock del taller.
        repairManager.addSparePart("exhaust pipe", 100);
        repairManager.addSparePart("motor", 80);
        repairManager.getSparePart().get(0).addItem(new Item(1));
        repairManager.getSparePart().get(1).addItem(new Item(1));


    }
    public static void main(String[] args) {
        RepairManager workShop = new RepairManager();
        init(workShop);
        List<Item> itemList = new ArrayList<Item>();
        itemList.add(new Item(1));
        itemList.add(new Item(1));

        // Imprimir todos los datos  del primer mecánico.
        System.out.println("This is the information of the first mechanic: "+ workShop.getMechanic(0).getName() + " " + workShop.getMechanic(0).getSurname());

        // Imprimir todos los datos del segundo vehículo.
        System.out.println("This is the information of the second vehicle: " + workShop.getVehicle(1).getMake() + ", " + workShop.getVehicle(1).getModel() + ", "+ workShop.getVehicle(1).getPlate().getNumber());

        // Registrar una reparación.
        workShop.repair(workShop.getVehicle(1), workShop.getMechanic(0),new Date(), "the car needs to change exhaust pipe and motor", 6, BreakdownTypes.mechanical, workShop.getSparePart(), itemList);
        System.out.println("_________________________________________________________________________" + "\n");

        // Formalizar pago de la reparación anterior.
        int price =  workShop.getMechanic(0).getRepair(0).price();

        // Borrar el primer vehículo.
        workShop.removeVehicle(0);

        // Imprimir el número de vehículos del taller.
        System.out.println("The number vehicles in the workshop is now: " + workShop.countVehicle());
        System.out.println("_________________________________________________________________________" + "\n");

        // Imprimir el propietario del vehículo.
        System.out.println("The owner of the vehicle " + workShop.getVehicle(0).getPlate().getNumber() + " is " + workShop.getVehicle(0).customer.getName());



        // Imprimir los datos de la reparación
        System.out.println("_________________________________________________________________________");
        System.out.println("                       INFORMATION OF THE REPAIR                                        ");
        System.out.println("_________________________________________________________________________" + "\n");

        System.out.println("The mechanic that is going to repair the vehicle is: "+ workShop.getMechanic(0).getName());
        System.out.println("The information of the vehicle to be repaired is: " + workShop.getVehicle(0).getPlate().getNumber() + " " + workShop.getVehicle(0).getMake() + " " +  workShop.getVehicle(0).getModel());
        System.out.println("Description and Breakdown Type: " + workShop.getMechanic(0).getRepair(0).getDescription() + "  ---->   " + workShop.getMechanic(0).getRepair(0).getBreakdownType());
        System.out.println("The name of the  first spare part is: " + workShop.getSparePart().get(0).getName());
        System.out.println("The name of the second spare part is: " + workShop.getSparePart().get(1).getName());
        System.out.println("The date of the repair is: " + workShop.getMechanic(0).getRepair(0).getDate() );
        System.out.println("The total price is: " + price + " pounds");


    }
}