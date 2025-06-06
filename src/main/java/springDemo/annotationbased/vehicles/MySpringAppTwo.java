package springDemo.annotationbased.vehicles;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySpringAppTwo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config2.xml");
        Vehicle vehicle = context.getBean("car", Vehicle.class);
        System.out.println(vehicle.getMileage());
        System.out.println(vehicle.start());
        System.out.println(vehicle.startAC());
        for (int i = 1; i <= 6; i++) {
            System.out.println(vehicle.increaseGear());
        }
        for (int i = 1; i < 5; i++) {
            System.out.println(vehicle.decreaseGear());
        }

    }
}
