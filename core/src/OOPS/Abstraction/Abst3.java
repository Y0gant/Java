package src.OOPS.Abstraction;

abstract class Appliance {
    static int count;
    String brand;
    Double powerRating;

    Appliance(String brand, Double powerRating) {
        this.brand = brand;
        this.powerRating = powerRating;
        count++;
    }

    static int getNoOfAppliances() {
        return count;
    }

    final String getBrand() {
        return brand;
    }

    abstract double calculateEnergyConsumption(int hours);

    abstract void displayDetails();
}

abstract class KitchenAppliance extends Appliance {
    KitchenAppliance(String brand, Double powerRating) {
        super(brand, powerRating);
    }

    @Override
    double calculateEnergyConsumption(int hours) {
        return (powerRating / 1000) * hours;
    }
}

class Refrigerator extends KitchenAppliance {
    String type;
    int capacity;

    Refrigerator(String brand, Double powerRating, String type, int capacity) {
        super(brand, powerRating);
        this.type = type;
        this.capacity = capacity;
    }

    @Override
    void displayDetails() {
        System.out.println("----------");
        System.out.println("Brand name :" + brand);
        System.out.println("Power rating :" + powerRating + "W");
        System.out.println("Type :" + type);
        System.out.println("Capacity :" + capacity + " liters");
    }
}

class Microwave extends KitchenAppliance {
    int capacity;

    Microwave(String brand, double powerRating, int capacity) {
        super(brand, powerRating);
        this.capacity = capacity;
    }

    @Override
    void displayDetails() {
        System.out.println("----------");
        System.out.println("Brand name :" + brand);
        System.out.println("Power rating :" + powerRating + "W");
        System.out.println("Capacity :" + capacity + " liters");

    }
}

public class Abst3 {
    public static void main(String[] args) {
        Appliance a1 = new Refrigerator("Bosh", 700.0, "Single door", 300);
        a1.displayDetails();
        System.out.printf("Energy consumption per 24hr: %.2f Kwh%n", a1.calculateEnergyConsumption(24));
        Appliance a2 = new Microwave("Samsung", 800, 12);
        a2.displayDetails();
        System.out.printf("Energy consumption per 24hr: %.2f Kwh%n", a2.calculateEnergyConsumption(24));
        Appliance a3 = new Microwave("LG", 600, 10);
        a3.displayDetails();
        System.out.printf("Energy consumption per 24hr: %.2f Kwh%n", a3.calculateEnergyConsumption(24));
        System.out.println("----------");
        System.out.println("Number of Appliances :" + Appliance.getNoOfAppliances());
    }
}
