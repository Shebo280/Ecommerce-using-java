public class ShippableProduct implements Shippable{
    private final Product product;
    private int quantity;

    public void setQuantity( int quantity) {
        this.quantity = quantity;
        // It updates the quantity in the Product object
        product.setQuantity(quantity);
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public ShippableProduct(Product product, int quantity){
        this.product=product;
        this.quantity=quantity;
    }

    @Override
    public String getName() {
        return product.getName();
    }

    // Weight of shippable product and its quantity
    @Override
    public double getWeight() {
        return quantity* product.getWeight();
    }
}
