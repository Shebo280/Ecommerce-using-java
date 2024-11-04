public class Customer {
 String name;
 double balance;

 public void setName(String name) {
  ValidationUtility.isEmptyName(name,"Customer's name");
  this.name = name;
 }

 public void setBalance(double balance) {
  ValidationUtility.checkPositive(true,balance,"Customer's balance");
   this.balance = balance;
 }

 public Customer(String name, double balance) {
  setName(name);
  setBalance(balance);
 }

}
