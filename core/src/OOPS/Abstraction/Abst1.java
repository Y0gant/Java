package src.OOPS.Abstraction;

//Abstract class (without implementation)
abstract class TvRemote {
    public abstract void turnOn();

    public abstract void turnOff();
}

//Concrete class implementing abstract methods
class InRemote extends TvRemote {

    @Override
    public void turnOn() {
        System.out.println("Turning on TV");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off TV");
    }
}

//Main class to demonstrate abstraction
public class Abst1 {
    public static void main(String[] args) {
        TvRemote remote1 = new InRemote();
        remote1.turnOn();
        remote1.turnOff();
    }
}
