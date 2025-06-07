package springDemo.annotationbased.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle {
    public Engine engine;
    public AirCondn ac;
    //Field injection
    @Autowired
    //@Qualifier("qualifierName")
    public Transmission transmission;
    @Value("${vehicle.mrp}")
    private int mrp;

    //Constructor injection
    @Autowired
    public Car(@Qualifier("electricEngine") Engine engine) {
        this.engine = engine;
    }

    @Override
    public int getMrp() {
        return mrp;
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
    //@Qualifier("qualifierName)
    public void setAc(AirCondn ac) {
        this.ac = ac;
    }

    @Override
    public String getMileage() {
        return "35 Kmpl";
    }
}
