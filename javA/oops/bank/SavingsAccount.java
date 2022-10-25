package oops.bank;

public class SavingsAccount extends BankAccount {

    private double interestRate;

    public SavingsAccount(String accountNumber, String password) {
        super(accountNumber, password);
        this.interestRate = 0.0;
    }

    public SavingsAccount(String accountNumber, String firstName, String lastName, String password, double initialBalance, double interestRate) {
        super(accountNumber, firstName, lastName, password, initialBalance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public void addInterest() {

        double interest = getBalance() * this.interestRate / 100.0;
        super.deposit(interest);
    }

    @Override
    public String toString(){

        return  "AccountN."+super.getAccountNumber()+"; Name: " + super.getFirstName()+ " "+ super.getLastName()+
                "; Balance: " + String.valueOf(super.getBalance()) + ". Interest rate : " + interestRate;
    }

}
