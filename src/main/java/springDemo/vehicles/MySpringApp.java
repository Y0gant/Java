package springDemo.vehicles;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySpringApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Vehicle bean = context.getBean("myVehicle", Car.class);
        System.out.println(bean.getMileage());
        System.out.println(bean.getDiscount());
        System.out.println(bean.getBrandName());
        System.out.println(bean.getCarPrice());
    }
}
