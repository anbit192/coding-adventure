package oops.bank;

public class CheckingAccount extends BankAccount {

    private int transactionCount;
    private static final int FREE_TRANSACTIONS = 3;
    private static final double TRANSACTIONS_FEE = 2.0;

    public CheckingAccount(String accountNumber, String firstName, String lastName, String password, double initialBalance) {
        super(accountNumber, firstName, lastName, password, initialBalance);
        this.transactionCount = 0;
    }

    public int getTransactionCount() {
        return this.transactionCount;
    }

    @Override
    public void deposit(double amount) {
        this.transactionCount ++;
        super.deposit(amount);
    }

    @Override
    public void withdraw(double amount) {
        this.transactionCount++;
        super.withdraw(amount);
    }

    // charge fees for each transaction, then reset transaction count to 0
    public void deductFees() {

        if (this.transactionCount > FREE_TRANSACTIONS) {
            double fees = TRANSACTIONS_FEE * (this.transactionCount - FREE_TRANSACTIONS);
            super.withdraw(fees);

            transactionCount = 0;
        }


    }


    @Override
    public void transfer(double amount, BankAccount other) {

        this.transactionCount++;
        this.deductFees();

        amount = Math.min(amount, super.getBalance());

        this.withdraw(amount);
        other.deposit(amount);
    }

    @Override
    public String toString(){

        return "AccountN."+super.getAccountNumber()+"; Name: " + super.getFirstName()+ " "+ super.getLastName()+
                "; Balance: " + String.valueOf(super.getBalance()) + ". Number of transactions : " + transactionCount;

    }
}
