package oopexercises.composition.account;

public class TestCustomer {
    public static void main(String[] args) {
        Customer an = new Customer(192, "anbish", 'm');
        System.out.println(an);
        Account acc1 = new Account(192, an, 99999);

        acc1.withdraw(9000);
        System.out.println(acc1);
        acc1.deposit(1234);
        System.out.println(acc1);
    }
}
