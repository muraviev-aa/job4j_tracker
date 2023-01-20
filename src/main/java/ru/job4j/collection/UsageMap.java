package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("hours@yandex.ru", "Hours Mike");
        map.put("woolf@yandex.ru", "Woolf Emma");
        map.put("elephant@yandex.ru", "Elephant Dorian");
        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }
}
