package com.farid.Divar.Test;

abstract class Car implements VehicleInterface {
    public int price = 0;

    Car(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
