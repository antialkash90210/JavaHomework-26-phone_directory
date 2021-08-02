package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class PhoneList {

    private String[] phone = null;
    private String fileName = null;

    public PhoneList() {
        phone = new String[0];
    }

    public PhoneList(String fileName) throws Exception {
        this.fileName = fileName;
        load();
    }

    public void clear() {
        phone = new String[0];
    }

    public String getByIndex(int index) throws Exception {
        if (index < 0 || index > phone.length - 1) {
            throw new Exception("Выход за границы");
        }

        return phone[index];
    }

    public void setByIndex(int index, String value) throws Exception {
        if (index < 0 || index > phone.length - 1) {
            throw new Exception("Выход за границы");
        }

        phone[index] = value;
    }

    public int getLength() {
        return phone.length;
    }


    public void addToEnd(String value) {
        String[] tempPhone = new String[phone.length + 1];

        for (int i = 0; i < phone.length; i++) {
            tempPhone[i] = phone[i];
        }

        tempPhone[tempPhone.length - 1] = value;

        phone = tempPhone;

    }

    public void deleteByIndex(int index) throws Exception {
        if (index < 0 || index > phone.length - 1) {
            throw new Exception("Выход за границы списка фраз");
        }

        String[] tempPhone = new String[phone.length - 1];

        for (int i = 0; i < index; i++) {
            tempPhone[i] = phone[i];
        }

        for (int i = index + 1; i < phone.length; i++) {
            tempPhone[i - 1] = phone[i];
        }

        phone = tempPhone;
    }

    public void addRange(String[] phone) {
        for (int i = 0; i < phone.length; i++) {
            addToEnd(phone[i]);
        }
    }

    public void load() throws Exception {
        clear();

        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int length = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < length; i++) {
            String currentValue = bufferedReader.readLine();
            addToEnd(currentValue);
        }

        bufferedReader.close();
    }

    public void save() throws Exception {
        if (fileName == null) {
            throw new Exception("file name was not set");
        }

        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write(phone.length+"\n");

        for (int i = 0; i < phone.length; i++) {
            bufferedWriter.write(phone[i]+"\n");
        }

        bufferedWriter.close();


    }

}