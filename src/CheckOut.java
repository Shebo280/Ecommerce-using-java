public class CheckOut {
public static void validatingPayment(Customer customer, Cart cart){
    // Checking if the cart is not empty or null first.
    ValidationUtility.isCartEmpty(cart);
    double totalCartCost = Cart.getSubtotal(cart) + Cart.getShippableAmount(cart);
    // Checking if the customer balance is enough
    if(ValidationUtility.checkAvailability(totalCartCost,customer.balance, "Customer's balance")){
        // Decreasing customer's balance
        customer.balance-=totalCartCost;
        // Printing Shipment Notice
        Cart.printShipmentNotice(cart);
        System.out.println();
        // Printing Checkout Receipt
        Cart.printCheckoutReceipt(cart);
        System.out.println("-----------------------------");
        System.out.println("Subtotal\t" + '$' + Cart.getSubtotal(cart));
        System.out.println("Shipping\t" + '$' + Cart.getShippableAmount(cart));
        System.out.println("Amount\t" +  '$' +totalCartCost);
        // Printing Customer's remaining balance.
        System.out.println("Remaining Balance " + '$' + customer.balance);
    }
}
}
