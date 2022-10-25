package oops.bank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class BankManagement {

    public static char getChar(String str, int index) {

        return str.charAt(index);
    }

    public static ArrayList<BankAccount> readData(String fileName) {

        ArrayList<BankAccount> accounts = new ArrayList<>();

        try {

            File file = new File(fileName);
            Scanner scan = new Scanner(file);

            String accountNumber;
            String firstName;
            String lastName;
            String password;
            double balance;
            char typeOfAccount;
            double interestRate;


            while (scan.hasNextLine()) {

                accountNumber = scan.next();
                firstName = scan.next();
                lastName = scan.next();
                password = scan.next();
                balance = Double.parseDouble(scan.next());
                typeOfAccount = getChar(accountNumber, 0);

                if (typeOfAccount == '1') {
                    interestRate = Double.parseDouble(scan.next());

                    BankAccount savingAccount = new SavingsAccount(accountNumber, firstName, lastName, password, balance, interestRate);
                    accounts.add(savingAccount);
                }

                else {
                    BankAccount checkingAccount = new CheckingAccount(accountNumber, firstName, lastName, password, balance);
                    accounts.add(checkingAccount);
                }
            }

            scan.close();
        }

        catch (FileNotFoundException fnfe) {
            System.out.println("Cannot open file " + fileName);
            fnfe.printStackTrace();
        }

        return accounts;
    }


    public static void displayList(ArrayList<BankAccount> accounts) {
        for (BankAccount acc : accounts) {
            System.out.println(acc.toString());
        }
    }


    public static ArrayList<BankAccount> savingAccountsList(ArrayList<BankAccount> accounts) {

        ArrayList<BankAccount> savingAccounts = new ArrayList<>();

        for (BankAccount account : accounts) {

            if (account.getClass().getName().equals("oops.bank.SavingsAccount")) {

                savingAccounts.add(account);
            }
        }

        return savingAccounts;
    }


    public static ArrayList<BankAccount> checkingAccountsList(ArrayList<BankAccount> accounts) {

        ArrayList<BankAccount> checkingAccounts = new ArrayList<>();

        for (BankAccount account : accounts) {

            if (account.getClass().getName().equals("oops.bank.CheckingAccount")) {

                checkingAccounts.add(account);
            }
        }

        return checkingAccounts;
    }


    public static void sortByBalance(ArrayList<BankAccount> accounts) {

        boolean done = false;
        BankAccount temp;

        while (!done) {
            done = true;

            for (int i = 0; i<accounts.size()-1; i++) {
                if (accounts.get(i).getBalance() > accounts.get(i+1).getBalance()) {

                    temp = accounts.get(i);
                    accounts.set(i, accounts.get(i+1));
                    accounts.set(i+1, temp);
                }
            }
        }
    }


    public static void saveToFile(ArrayList<BankAccount> accounts, String fileName) {

        try {

            Formatter fm = new Formatter(fileName);

            String accountNumber;
            String firstName;
            String lastName;
            double balance;
            double interestRate;
            int transactionCount;

            for (BankAccount account : accounts) {

                accountNumber = account.getAccountNumber();
                firstName = account.getFirstName();
                lastName = account.getLastName();
                balance = account.getBalance();

                if (account.getClass().getName().equals("SavingsAccount")) {

                    interestRate = ((SavingsAccount) account).getInterestRate();
                    fm.format("%s%n%s %s%n%.2f%n%.3f%n", accountNumber, firstName, lastName, balance, interestRate);
                }

                else if (account.getClass().getName().equals("CheckingAccount")) {

                    transactionCount = ((CheckingAccount) account).getTransactionCount();
                    fm.format("%s%n%s %s%n%.2f%n%d%n", accountNumber, firstName, lastName, balance,transactionCount);
                }
            }

        }

        catch (FileNotFoundException e) {

            System.out.println("Cannot access file " + fileName + " to write!\n" + e.getMessage());
        }
    }

    public static ArrayList<BankAccount> filterByBalance(ArrayList<BankAccount> listAccount,
                                                         double upperBound, double lowerBound){
        ArrayList<BankAccount> results  = new ArrayList<>();

        for (BankAccount account : listAccount) {

            if (account.getBalance()>lowerBound && account.getBalance()<upperBound) {

                results.add(account);
            }
        }

        return results;
    }


    public static void main(String[] args) {

        System.out.println("Original list:");
        ArrayList<BankAccount> accounts = readData("C:\\Users\\minha\\Desktop\\Tai lieu hoc tap\\THJava\\oops\\bank\\data.txt.txt");
        displayList(accounts);


        saveToFile(accounts,"C:\\Users\\minha\\Desktop\\Tai lieu hoc tap\\THJava\\oops\\bank\\test.txt");

        System.out.println("Saving accounts list:");
        ArrayList<BankAccount> savingAccounts = savingAccountsList(accounts);
        displayList(savingAccounts);

        System.out.println("Checking accounts list:");
        ArrayList<BankAccount> checkingAccounts = checkingAccountsList(accounts);
        displayList(checkingAccounts);

        System.out.println("Filter accounts: ");
        ArrayList<BankAccount> filterAccounts = filterByBalance(accounts, 9000, 1000);
        displayList(filterAccounts);

        System.out.println("Sorted list: ");
        sortByBalance(accounts);
        displayList(accounts);

    }
}
