package springDemo.vehicles;

public class Car implements Vehicle {
    private DiscountService service;

//    public Car(FestiveDiscountImpl discount) {
//        this.service = discount;
//    }

    public Car() {

    }

    @Override
    public String getMileage() {
        return "35 Kmpl";
    }

    @Override
    public String getDiscount() {
        return service.getDiscount();
    }

    @Override
    public void setDiscountService(DiscountService service) {
        this.service = service;
    }

}
