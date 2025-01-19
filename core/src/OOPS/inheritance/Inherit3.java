package src.OOPS.inheritance;

/**
 * Write a program with three classes: Vehicle (base class), Car (intermediate class), and ElectricCar (derived class).
 * Add methods in each class to display their features. Call all methods using the ElectricCar object.
 */
class Vehicle {

    int bhp;
    int groundClearance;
    String brand;
    String driveType;
    byte globalNCAP;

    Vehicle(int bhp, int groundClearance, String brand, String driveType, byte globalNCAP) {
        this.bhp = bhp;
        this.groundClearance = groundClearance;
        this.brand = brand;
        this.driveType = driveType;
        this.globalNCAP = globalNCAP;
    }

    void displayVehicleDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("BHP: " + bhp);
        System.out.println("Ground Clearance: " + groundClearance + " mm");
        System.out.println("Drive Type: " + driveType);
        System.out.println("Global NCAP Rating: " + globalNCAP);
    }
}

class Car extends Vehicle {
    String transmission;
    int engine;

    Car(int bhp, int groundClearance, String brand, String driveType, byte globalNCAP, String transmission, int engine) {
        super(bhp, groundClearance, brand, driveType, globalNCAP);
        this.transmission = transmission;
        this.engine = engine;
    }

    void displayCarDetails() {
        displayVehicleDetails();
        System.out.println("Transmission: " + transmission);
        System.out.println("Engine: " + engine + " cc");
    }
}

class ElectricCar extends Car {
    int batteryCapacity; // in kWh
    int range; // in kilometers

    ElectricCar(int bhp, int groundClearance, String brand, String driveType, byte globalNCAP, String transmission,
                int engine, int batteryCapacity, int range) {
        super(bhp, groundClearance, brand, driveType, globalNCAP, transmission, engine);
        this.batteryCapacity = batteryCapacity;
        this.range = range;
    }

    void displayElectricCarDetails() {
        displayCarDetails();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
        System.out.println("Range: " + range + " km");
    }
}

public class Inherit3 {
    public static void main(String[] args) {
        ElectricCar tesla = new ElectricCar(300, 140, "Tesla", "AWD", (byte) 5, "Automatic", 0, 100, 500);
        tesla.displayElectricCarDetails();
    }
}
