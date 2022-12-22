package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Drive");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("Number of passengers: " + passengers);
    }

    @Override
    public double refuel(double fuel) {
        double price = 0.8;
        return fuel * price;
    }
}
