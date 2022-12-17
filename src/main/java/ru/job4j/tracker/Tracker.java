package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        int count = 0;
        Item[] items1 = new Item[items.length];
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                items1[count] = items[i];
                count++;
            }
        }
        return Arrays.copyOf(items1, count);
    }

    public Item[] findByName(String key) {
        Item[] items1 = new Item[size];
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (key.equals(items[i].getName())) {
                items1[counter++] = items[i];
            }
        }
        return Arrays.copyOf(items1, counter);
    }
}