package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int res = 0;
        for (int i = 0; i < Math.min(left.length(), right.length()); i++) {
            res += Character.compare(left.charAt(i), right.charAt(i));
            if (res != 0) {
                break;
            }
        }
        if (res == 0) {
            res = Integer.compare(left.length(), right.length());
        }
        return res;
    }
}
