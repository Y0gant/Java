package springDemo.xmlbased.vehicles;

public class FestiveDiscountImpl implements DiscountService {
    @Override
    public String getDiscount() {
        return "Motors, India’s leading automotive manufacturer,\n" +
                "has launched its biggest ever ‘Festival of Cars’ with amazing offers for this festive season." +
                " \nWith never-before-seen pricing for several of its popular Cars and SUVs plus a bouquet of additional consumer benefits available at our showrooms.";

    }
}
