package org.example;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(15000);

        System.out.println("Ваш баланс " + account.getAmount ());
        while (true) {
            try {
                account.withDraw (6000);
                System.out.println ("Вы вывели 6000 сом. Ваш баланс " + account.getAmount () + " сом.");
            } catch (LimitException e) {
                System.out.println (e.getMessage ());
                System.out.println ("Вы можете вывести только  " + e.getRemainingAmount () + " сом.");
                try {
                    account.withDraw ((int) e.getRemainingAmount ());
                    System.out.println ("Вы вывели " + e.getRemainingAmount () + " сом. Ваш баланс " + account.getAmount () + " сом.");
                } catch (LimitException ex) {
                    System.out.println (ex.getMessage ());
                }
                break;
            }
        }
    }
}