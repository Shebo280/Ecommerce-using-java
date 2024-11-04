import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {

        // Examples for handling corner cases for product

        // 1. Product is duplicated
//        new Product("cheese", 150, 2,LocalDate.of(2025,2,10)
//                ,true,500.0);
//        new Product("cheese", 150, 8,LocalDate.of(2024,12,10)
//                ,true,240.0);

        // 2. Accessing Product name by uppercase or lower case it works and It consider them 1 product!
//        new Product("cheese", 150, 8,LocalDate.of(2025,2,10)
//                ,true,500.0);
//        Customer c1 = new Customer("Mohamed", 8500);
//        Cart cart= new Cart();
//        cart.addToCart("Cheese", 2);
//        cart.addToCart("cheese", 2);
//        cart.addToCart("CHEESE", 5);
//        CheckOut.validatingPayment(c1,cart);

        // 3. Weight of product for shippable and non-shippable products
//        new Product("cheese", 150, 8,LocalDate.of(2025,2,10)
//                ,true,null);
//        new Product("cheese", 150, 8,LocalDate.of(2025,2,10)
//                ,true,0.0);
//        new Product("cheese", 150, 8,LocalDate.of(2025,2,10)
//                ,false,100.0);

        // 4. Product's quantity should be positive , Product's price can't be negative
//        new Product("cheese", -150, 8,LocalDate.of(2025,2,10)
//                ,true,100.0);
//        new Product("cheese", 0, 8,LocalDate.of(2025,2,10)
//                ,true,100.0);
//        new Product("cheese", 100, -5,LocalDate.of(2025,2,10)
//                ,true,100.0);
        // 5. Product's name is null or empty
//        new Product(null, 100, -5,LocalDate.of(2025,2,10)
//                ,true,100.0);
//        new Product("", 100, -5,LocalDate.of(2025,2,10)
//                ,true,100.0);

        //                          ---------------------------------------------

        // Examples for handling corner cases for customer

        // 1. Customer's name is null or empty
//        new Customer(null, 8500);
//        new Customer("", 8500);

        //2. Customer's balance is negative
//        new Customer("Mohamed", -8500);

        //                          ---------------------------------------------

        // Examples for handling corner cases for cart

//        new Product("cheese", 150, 2,LocalDate.of(2025,2,10)
//                ,true,500.0);
//        new Product("milk", 150, 8,LocalDate.of(2026,12,10)
//                ,true,240.0);
//        Customer c1 = new Customer("Mohamed", 8500);

        // 1. Cart is empty
//        Cart cart= new Cart();
//        CheckOut.validatingPayment(c1,cart);

        // 2. Cart is null
//        Cart cart= null;
//        CheckOut.validatingPayment(c1,cart);

        // 3. Cart contains expired product
//        new Product("TV", 150, 8,LocalDate.of(2023,12,10)
//                ,true,240.0);
//        Cart cart= new Cart();
//        cart.addToCart("TV" , 2);
//        CheckOut.validatingPayment(c1,cart);

        // 4. Adding out-of-stock product to cart
//        new Product("TV", 150, 2,LocalDate.of(2028,12,10)
//                ,true,240.0);
//        Cart cart= new Cart();
//        cart.addToCart("TV" , 2);
//        cart.addToCart("TV" , 1);
//        CheckOut.validatingPayment(c1,cart);

        //                          ---------------------------------------------

        //  Examples for handling corner cases for checkout
        // 1. Customer's balance is insufficient
//        new Product("cheese", 150, 2,LocalDate.of(2025,2,10)
//                ,true,500.0);
//        new Product("milk", 250, 8,LocalDate.of(2026,12,10)
//                ,true,240.0);
//        Customer c1 = new Customer("Mohamed", 500);
//        Cart cart= new Cart();
//        cart.addToCart("Milk" , 2);
//        cart.addToCart("milk" , 3);
//        CheckOut.validatingPayment(c1,cart);

        //                          ---------------------------------------------

        // Example

        new Product("cheese", 150, 2,LocalDate.of(2025,2,10)
                ,true,500.0);
        new Product("milk", 150, 8,LocalDate.of(2024,12,10)
                ,true,240.0);
        new Product("Laptop", 3500, 10,null
                ,true,3500.0);
        new Product("TV", 1500, 4,null ,true,240.0);

        Customer c1 = new Customer("Mohamed", 20000);
        Cart cart= new Cart();
        cart.addToCart("Cheese", 2);
        cart.addToCart("Milk", 2);
        cart.addToCart("TV", 3);
        cart.addToCart("Laptop", 2);
        cart.addToCart("laptop", 2);


        CheckOut.validatingPayment(c1,cart);
    }
}