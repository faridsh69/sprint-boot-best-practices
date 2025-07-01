package com.farid.Divar.Test;

public class Benz extends Car {
    Benz(int price) {
        super(price);
    }

    @Override
    public int getPrice() {
        return price + 2;
    }

    public void run() {
        System.out.println("This code is running in a thread");
    }
}
