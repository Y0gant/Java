package springDemo.vehicles;

public class Bus implements Vehicle {

    private DiscountService service;

    public Bus(FestiveDiscountImpl discount) {
        this.service = discount;
    }

    public Bus() {

    }

    @Override
    public String getMileage() {
        return "15 Kmpl";
    }

    @Override
    public String getDiscount() {
        return this.service.getDiscount();
    }

    @Override
    public void setDiscountService(DiscountService service) {
        this.service = service;
    }


}
