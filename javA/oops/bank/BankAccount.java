package oops.bank;

public class BankAccount {

    private String accountNumber;
    private String firstName = "XXXX";
    private String lastName = "XXXX";
    private String password = "****";
    private double balance;

    public BankAccount(String accountNumber, String password) {
        accountNumber = accountNumber;
        password = password;
        this.balance = 0;
    }


    public BankAccount(String accountNumber, String firstName, String lastName, String password, double initialBalance) {
        this.accountNumber = accountNumber;
        this.firstName = normalizeName(firstName);
        this.lastName = normalizeName(lastName);
        this.password = password;
        this.balance = initialBalance;
    }


    public static String normalizeName(String name){
        String str = name;
        str = str.trim();
        str = str.replaceAll("\\s+"," ");
        char[] ch = str.toCharArray();

        ch[0] = Character.toUpperCase(ch[0]);

        for(int i = 1 ; i < ch.length; i++)
            if(ch[i-1] == ' ')
                ch[i] = Character.toUpperCase(ch[i]);
            else
                ch[i] = Character.toLowerCase(ch[i]);

        return String.valueOf(ch);
    }

    // Get account info
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getBalance() {
        return balance;
    }

    // deposit & withdraw
    public void deposit(double amount) {
        this.balance = this.getBalance() + amount;
    }

    public void withdraw(double amount) {
        this.balance = this.getBalance() - amount;
    }

    // set & change password
    public boolean setPassword(String oldPassword, String newPassword) {
        boolean check = oldPassword.equals(this.password);

        if (check) {
            this.password = newPassword;
        }

        return check;
    }

    // transfer
    public void transfer(double amount, BankAccount other) {
        this.withdraw(amount);
        other.deposit(amount);
    }


    @Override
    public String toString() {
        return "AccountN."+accountNumber+"; Name: " + firstName+ " "+ lastName +
                "; Balance: " + String.valueOf(balance);
    }
}
