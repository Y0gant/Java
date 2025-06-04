package springDemo.xmlbased.vehicles;

public class MyApp {

    public static void main(String[] args) {

        try {
            Vehicle vehicle = new Car();
            System.out.println(vehicle.getMileage());
            System.out.println(vehicle.getDiscount()); //will throw Null pointer exception
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}