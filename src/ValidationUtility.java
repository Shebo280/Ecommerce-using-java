public class ValidationUtility {
    // Handling negative value and zero for specific attributes
    public static boolean checkPositive(boolean zeroAllowed, double value, String attributeName){
        // For product's weight and price, they can't be zero!
        if (!zeroAllowed && value<=0) throw new Error(attributeName + " Must be a positive Number.");
        // For quantity and customer's balance it can be zero!
        else if (zeroAllowed && value<0) throw new Error(attributeName + " Can not be a negative Number.");
        else return true;
    }
    // Helper function to check availability for balance and quantity.
    public static boolean checkAvailability(double valueWanted, double availableValue, String valueName){
        if (valueWanted<=availableValue) return true;
        else throw new Error("There is not enough " + valueName);
    }
    // Helper function to check if the cart is empty or not
    public static void isCartEmpty(Cart cart) {
        // If the cart is null
        if (cart == null || cart.getCartProducts().isEmpty()) {
            throw new Error("Cart can't be null or empty.");
        }
    }

    public static boolean isEmptyName (String name, String attributeName){
        if(name == null || name.isEmpty()){
            throw new Error(attributeName + " Can't be null or empty.");
        }
        else return false;
    }
    public static String isKiloGram(double value){
       return (value >= 1000) ? value/1000 + "kg" : value +"g";
    }
}
