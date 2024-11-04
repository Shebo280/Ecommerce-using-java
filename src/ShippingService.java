import java.util.List;

public class ShippingService {

    public static double getShippingCost(Cart cart) {
        List<ShippableProduct> shippableProducts= cart.getShippableProducts();
        double totalWeight =0;
        for (Shippable shippableProduct : shippableProducts) {
            totalWeight += shippableProduct.getWeight();
        }
        // Converting from gram to KG
        totalWeight/=1000;
        // The cost will be 5$ for each Kg
        return totalWeight*5;
    }


}
