package ru.job4j.ex;

import java.util.Objects;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < value.length; index++) {
            if (Objects.equals(value[index], key)) {
                rsl = index;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element not found");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] strings = {"One", "Two", "Three"};
        String str = "Test";
        try {
            indexOf(strings, str);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
