package springDemo.annotationbased.vehicles;

import org.springframework.stereotype.Component;

@Component
public class AirCondnImpl implements AirCondn {
    @Override
    public String startAC() {
        return "Started Air Conditioner";
    }
}
