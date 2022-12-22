package ru.job4j.oop;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle airplane1 = new Airplane();
        Vehicle airplane2 = new Airplane();
        Vehicle train1 = new Train();
        Vehicle train2 = new Train();
        Vehicle bus1 = new Bus();
        Vehicle bus2 = new Bus();

        Vehicle[] vehicles = new Vehicle[]{airplane1, airplane2, train1, train2, bus1, bus2};
        for (Vehicle v : vehicles) {
            v.move();
        }
    }
}
