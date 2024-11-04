import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Product {
    // It maps the product name with the product object, to access the product by its name.
    private static final Map<String, Product> productMap = new HashMap<>();

    private final int id;
    // Starting with 0 because we will increment it in Constructor, so it will be 1.
    private static int nextId = 0;
    private String name;
    private double price;

    private int quantity;

    private LocalDate expiryDate = null;
    private Boolean shippable;
    private Double weight= null;

    public int getId(){
        return id;
    }
    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public Boolean getShippable() {
        return shippable;
    }

    public Double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }


    public Product(String name, double price, int quantity, LocalDate expiryDate, Boolean shippable, Double weight) {
        this.id=++nextId;
        setName(name);
        setPrice(price);
        setQuantity(quantity);
        setExpiryDate(expiryDate);
        setShippable(shippable);
        setWeight(weight);
        // If there are not any errors, then add that product to the map.
        productMap.put(this.name,this);
    }

    public void setName(String name) {
        // It handles empty and null names.
        ValidationUtility.isEmptyName(name,"Product's name");

        // It converts the name to lowerCase, so it can accept the uppercase.
        this.name = name.toLowerCase();
        // It checks it the product already exists or not.
        if (productMap.containsKey((this.name))) {
            throw new Error("The product " + name + " already exists.");
        }
    }

    public void setPrice(double price) {
        // It handles the negative value and zero
        ValidationUtility.checkPositive(false,price,name + "'s price");
        this.price = price;
    }

    public void setQuantity(int quantity) {
        // It handles the negative value and zero
        ValidationUtility.checkPositive(true,quantity,name + "'s quantity");
        this.quantity = quantity;
    }

    public void setExpiryDate(LocalDate expiryDate) {

        this.expiryDate = expiryDate;
    }

    public void setShippable(Boolean shippable) {
        this.shippable = shippable;
    }

    public void setWeight(Double weight) {
        // If the product is shippable, but the weight is null.
        if (shippable && weight==null) {
            throw new Error("Shippable products should have a weight.");
        }
        // If the product is non-shippable, but there is a weight.
        else if (!shippable && weight!=null){
            throw new Error("Non-shippable products can not have a weight.");
        }
        // Checking if the weight is negative or zero.
        else if(weight != null)
        {
            ValidationUtility.checkPositive(false,weight,name + "'s weight");
        }
        this.weight=weight;
    }

    // Accessing a product from the map
    public static Product getProduct(String name) {
        name = name.toLowerCase();
        return productMap.get(name);
    }




}
