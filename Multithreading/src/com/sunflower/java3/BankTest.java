package com.sunflower.java3;



public class BankTest {

}
class Bank{
    private static Bank instance = null;

    public static Bank getInstance() {
        if (instance == null) {
            synchronized(Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
            return instance;
        }
        return instance;
    }
}
