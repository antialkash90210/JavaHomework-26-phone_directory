package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        PhoneList phoneDirectoryCallToAction  = new PhoneList("phoneDirectoryCallToAction.txt");
        PhoneList phonePrice = new PhoneList("phonePrice.txt");
        PhoneList phoneDiagonal = new PhoneList("phoneDiagonal.txt");
        PhoneList numberOfPhonesInStock = new PhoneList("numberOfPhonesInStock.txt");
        PhoneList phoneColor = new PhoneList("phoneColor.txt");

        PhoneStringGenerator phoneStringGenerator = new PhoneStringGenerator(phoneDirectoryCallToAction , phonePrice, phoneDiagonal, numberOfPhonesInStock, phoneColor);

        MenuManager menuManager = new MenuManager(phoneStringGenerator);
        menuManager.executeOperationsOnThePhoneList();
    }
}
