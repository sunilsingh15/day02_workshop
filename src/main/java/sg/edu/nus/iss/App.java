package sg.edu.nus.iss;

import java.util.Random;
import java.util.UUID;

public class App 
{
    public static void main( String[] args )
    {
        BankAccount accountOne = new BankAccount("Sunil", "401-23459-4", 10123);
        System.out.println(accountOne.toString()); 

        accountOne.deposit(10000);
        System.out.println(accountOne.toString());

        accountOne.withdraw(50);
        System.out.println(accountOne.toString());

        accountOne.setClosed(true);

        // accountOne.withdraw(50);
        // System.out.println(accountOne.toString());

        for(String transDetails: accountOne.getTransactions()) {
            System.out.println(transDetails);
        }

        int n = 5;
        BankAccount [] bankAcct = new BankAccount[n];

        for (int i=0; i<bankAcct.length; i++) {
            String uuid = UUID.randomUUID().toString();

            float min = 1000;
            float max = 100000;

            Random randomNum = new Random();
            float initialBalance = min + randomNum.nextFloat();

            bankAcct[i] = new BankAccount("Employee " + String.valueOf(i), uuid, initialBalance);
        }

        bankAcct[0].toString();

        FixedDepositAccount fredFixedD = new FixedDepositAccount("Fred", "002-00001-FD", 30000.00f, 10.0f, 1);
        fredFixedD.deposit(20000.00f);
        fredFixedD.withdraw(20000.00f);

        float computedBalance = fredFixedD.getBalance();

        System.out.println(fredFixedD.getAccountNumber() + " - " + fredFixedD.getFullName() + " --> Balance: " + computedBalance);
    }
}
