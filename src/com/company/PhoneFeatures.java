package com.company;

public class PhoneFeatures {
    private int id;
    private Phone[] phones;

    public PhoneFeatures() {
        id = 0;
        phones = new Phone[0];
    }

    //region Util Methods

    private int getIndexByIdCar(int id) {

        int index = -1;
        int middle = phones.length / 2;
        int first = 0;
        int last = phones.length - 1;

        if (id < phones[first].getId() || id > phones[last].getId()) {
            return -1;
        }

        do {
            if (id < phones[middle].getId()) {
                last = middle - 1;
                middle = (first + last) / 2;
            } else if (id > phones[middle].getId()) {
                first = middle + 1;
                middle = (first + last) / 2;

            } else {
                index = middle;
                break;
            }
        }
        while (first <= last);

        return index;
    }

    //endregion

    //region Main Methods

    public void addCar(int enginePower, double maxSpeed, double weight, String brandName, String model, Phone.Color color) {
        id++;
        Phone phone = new Phone(id, enginePower, maxSpeed, weight, brandName, model, color);

        Phone[] tempPhones = new Phone[phones.length + 1];

        for (int i = 0; i < phones.length; i++) {
            tempPhones[i] = phones[i];
        }

        tempPhones[tempPhones.length - 1] = phone;

        phones = tempPhones;
    }

    public void deleteCar(int id) throws Exception {
        int index = getIndexByIdCar(id);

        if (index == -1) {
            throw new Exception("car with id = " + id + " not found");
        }

        Phone[] tempPhones = new Phone[phones.length - 1];

        for (int i = 0; i < index; i++) {
            tempPhones[i] = phones[i];
        }

        for (int i = index + 1; i < phones.length; i++) {
            tempPhones[i - 1] = phones[i];
        }

        phones = tempPhones;
    }

    public Phone getByIdCar(int id) throws Exception {
        int index = getIndexByIdCar(id);

        if (index == -1) {
            throw new Exception("car with id = " + id + " not found");
        }

        return phones[index];
    }

    public void printCars() {
        if (phones.length == 0) {
            System.out.println("Список пуст");
            System.out.println("==========");
        } else {
            for (int i = 0; i < phones.length; i++) {
                System.out.println(phones[i].getInString());
                System.out.println("==========");
            }
        }
    }

    //endregion
}