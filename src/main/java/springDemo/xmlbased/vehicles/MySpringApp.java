package springDemo.xmlbased.vehicles;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySpringApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Vehicle bean = context.getBean("myVehicle", Car.class);
        System.out.println(bean.getMileage());
        System.out.println(bean.getDiscount());
        System.out.println(bean.getBrandName());
        System.out.println(bean.getCarPrice());
        //Prototype bean
        Vehicle bean2 = context.getBean("myVehicle", Car.class);
        System.out.println("comparing prototype beans -");
        System.out.println(bean == bean2);

        //singleton bean
        Vehicle busBean1 = context.getBean("myVehicle2", Bus.class);
        Vehicle busBean2 = context.getBean("myVehicle2", Bus.class);
        System.out.println("comparing singleton beans -");
        System.out.println(busBean1 == busBean2);

    }
}
