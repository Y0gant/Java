package springDemo.annotationbased.vehicles;

import org.springframework.stereotype.Component;

@Component
public class TransmissionImpl implements Transmission {
    int gear = 0;

    @Override
    public int increaseGear() {
        if (gear == 6) {
            return 6;
        }
        gear++;
        return gear;
    }

    @Override
    public int decreaseGear() {
        if (gear == 0) {
            return 0;
        }
        gear--;
        return gear;
    }
}
