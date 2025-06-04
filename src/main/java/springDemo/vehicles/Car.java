package springDemo.vehicles;

public class Car implements Vehicle {
    private DiscountService service;
    private String brandName;
    private double mrp;

    public Car() {

    }

    @Override
    public double getCarPrice() {
        return mrp;
    }
//    public Car(FestiveDiscountImpl discount) {
//        this.service = discount;
//    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
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

    public void setMrp(double mrp) {
        this.mrp = mrp;
    }
}
