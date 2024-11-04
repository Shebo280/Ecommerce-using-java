import java.time.LocalDate;
import java.util.*;

public class Cart {

    private List<Map<Product, Integer>> cartProducts = new ArrayList<>();
    private List<ShippableProduct> shippableProducts = new ArrayList<>();

    // Adding the bought products while handling some cases.
    public void addToCart(String productName, int quantity){
        Product product = Product.getProduct(productName);
        // Checking if the product is available
        if (product == null) {
            throw new Error(productName + " does not exist in the cart.");
        }


       // Checking if the wanted quantity does not exceed available quantity
     if (ValidationUtility.checkAvailability(quantity,product.getQuantity(),productName)){

         // Checking if the product does not have expiry date or if it's not expired yet.
         if(product.getExpiryDate() == null || !isExpired(product,product.getExpiryDate())){

             // Checking if that product was previously bought (just modify quantity)
             boolean productFound = updateProductQuantityIfExists(product.getName(),quantity);

             if (!productFound){
                 // Creating a map for the product and its quantity and adding it to List
                 Map<Product, Integer> boughtProduct = new HashMap<>();
                 boughtProduct.put(product, quantity);
                 cartProducts.add(boughtProduct);

                 // Checking if the product is shippable adding it to shippable products
                 if(product.getShippable()) shippableProducts.add(new ShippableProduct(product,quantity));
             }


             // Decreasing the quantity
             product.setQuantity(product.getQuantity()-quantity);
         }
     }
    }

    public List<Map<Product, Integer>> getCartProducts(){
        return cartProducts;
    }
    public List<ShippableProduct> getShippableProducts(){
        return shippableProducts;
    }

    // Helper function checking if product already exists in the cart
    private boolean updateProductQuantityIfExists(String productName, int quantity) {
        boolean foundProduct = false;
        // Getting the product instance based one name
        Product product = Product.getProduct(productName);

        // Check if the product exists
        if (product == null) {
            throw new Error(productName + " does not exist in the cart.");
        }

        // Modifying the quantity in the cart products.
        for (Map<Product, Integer> productMap : cartProducts) {
            if (productMap.containsKey(product)) {
                int existingQuantity = productMap.get(product);
                productMap.put(product, existingQuantity + quantity);
                foundProduct = true;
            }
        }

        // Modifying the quantity in the shippable products if the product is shippable
        if (product.getShippable()) {
            for (ShippableProduct shippableproduct : shippableProducts) {
                if (shippableproduct.getName().equals(product.getName())) {
                    int existingQuantity = shippableproduct.getQuantity();
                    shippableproduct.setQuantity(existingQuantity + quantity);
                    foundProduct = true;
                }
            }
        }
        return foundProduct;
    }



    // Helper function checking expired products
    private boolean isExpired(Product product, LocalDate date){
        // It means we passed the expiry date
        if (date.isBefore(LocalDate.now()))
        {
            throw new Error(product.getName() + " Is exipred.");
        }
        else return false;
    }

    // Getting the subtotal
    public static double getSubtotal(Cart cart){
        double subTotal=0;
        for (Map<Product, Integer> productMap : cart.cartProducts) {
            for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
                Product product = entry.getKey();
                Integer quantity = entry.getValue();
                subTotal += product.getPrice()*quantity;
            }
        }
        return subTotal;
    }
    // Getting the shipped Amount by using ShippingService
    public static double getShippableAmount(Cart cart){
        return ShippingService.getShippingCost(cart);
    }

    // Helper functions for printing checkout receipt
    public static void printCheckoutReceipt(Cart cart) {
        System.out.println("** Checkout receipt **");

        for (Map<Product, Integer> productMap : cart.cartProducts) {
            for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
                Product product = entry.getKey();
                Integer quantity = entry.getValue();
                System.out.println(quantity + "x " + product.getName() + '\t' + '$' + quantity*product.getPrice());
            }
        }

    }
    // Helper function for printing shipment notice
    public static void printShipmentNotice(Cart cart){
        double totalWeight =0;
        System.out.println("** Shipment Notice **");
        for (ShippableProduct shippableProduct : cart.shippableProducts) {
            System.out.println(shippableProduct.getQuantity() + "x " + shippableProduct.getName() +
                    '\t' + ValidationUtility.isKiloGram(shippableProduct.getWeight()));
            totalWeight+=shippableProduct.getWeight();
        }
        System.out.println("Total package weight " + totalWeight/1000 +"kg");
    }




}
