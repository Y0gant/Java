package springDemo.annotationbased.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle {
    public Engine engine;
    public AirCondn ac;
    //Field injection
    @Autowired
    public Transmission transmission;

    //Constructor injection
    @Autowired
    public Car(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String startAC() {
        return ac.startAC();
    }

    @Override
    public int increaseGear() {
        return transmission.increaseGear();
    }

    @Override
    public int decreaseGear() {
        return transmission.decreaseGear();
    }

    @Override
    public String start() {
        return engine.start();
    }

    //Setter injection
    @Autowired
    public void setAc(AirCondn ac) {
        this.ac = ac;
    }

    @Override
    public String getMileage() {
        return "35 Kmpl";
    }
}
