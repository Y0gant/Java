package springDemo.xmlbased.vehicles;

public class Bus implements Vehicle {

    private DiscountService service;

    private String brandName;

    private double mrp;

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

    @Override
    public double getCarPrice() {
        return mrp;
    }

    public void setMrp(double mrp) {
        this.mrp = mrp;
    }


    @Override
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
