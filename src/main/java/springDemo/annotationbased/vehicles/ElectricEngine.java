package springDemo.annotationbased.vehicles;


import org.springframework.stereotype.Component;

@Component
public class ElectricEngine implements Engine {
    @Override
    public String start() {
        System.out.println("Starting Electric engine..");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println("Error at starting engine");
        }
        return "Electric engine has started.....";
    }
}
