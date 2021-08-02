package com.company;

public class Phone {
    //region Enum Color

    public enum Color {
        red("красный"),
        green("зелёный"),
        blue("голубой"),
        black("чёрный"),
        yellow("жёлтый");

        private final String value;

        Color(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    //endregion

    //region Variables

    private int id;
    private int phoneDirectoryCallToAction;
    private double maxSpeed;
    private double weight;
    private String brandName;
    private String model;
    private Color color;

    //endregion

    //region Constructors

    public Phone() {
        id = 0;
        phoneDirectoryCallToAction = 50;
        maxSpeed = 130;
        weight = 0.57;
        brandName = "Ford";
        model = "Model T";
        color = Color.black;
    }

    public Phone(int id, int phoneDirectoryCallToAction, double maxSpeed, double weight, String brandName, String model, Color color) {
        this.id = id;
        this.phoneDirectoryCallToAction = phoneDirectoryCallToAction;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.brandName = brandName;
        this.model = model;
        this.color = color;
    }

    public Phone(int id, Phone phone) {
        this.id = id;
        phoneDirectoryCallToAction = phone.phoneDirectoryCallToAction;
        maxSpeed = phone.maxSpeed;
        weight = phone.weight;
        brandName = phone.brandName;
        model = phone.model;
        color = phone.color;
    }

    //endregion

    //region Setters

    public void setPhoneDirectoryCallToAction(int phoneDirectoryCallToAction) throws Exception {
        if (phoneDirectoryCallToAction <= 0 || phoneDirectoryCallToAction > 500) {
            throw new Exception("engine power must be grater than 0 and less then 501");
        }
        this.phoneDirectoryCallToAction = phoneDirectoryCallToAction;
    }

    public void setMaxSpeed(double maxSpeed) throws Exception {
        if (maxSpeed <= 0 || maxSpeed > 750) {
            throw new Exception("max speed must be grater than 0 and less then 401");
        }
        this.maxSpeed = maxSpeed;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    //endregion

    //region Getters

    public int getPhoneDirectoryCallToAction() {
        return phoneDirectoryCallToAction;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public Color getColor() {
        return color;
    }

    public int getId() {
        return id;
    }

    //endregion

    public String getInString() {
        String output = "";

        output += "ИД: " + id + "\n";
        output += "двигатель: " + phoneDirectoryCallToAction + "(лс)\n";
        output += "макс скорость: " + maxSpeed + "(км/ч)\n";
        output += "вес: " + weight + "(тонн)\n";
        output += "марка: " + brandName + "\n";
        output += "модель: " + model + "\n";
        output += "цвет: " + color.getValue();

        return output;
    }

}