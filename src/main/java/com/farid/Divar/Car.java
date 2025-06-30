package com.farid.Divar;

abstract class Car implements VehicleInterface {
    public int price = 0;

    Car (int price) {
        this.price = price;
    }

    public abstract int getPrice();
}
