package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        int answer = new Random().nextInt(3);
        String text;

        Scanner input = new Scanner(System.in);
        System.out.println("Я великий Оракул. Что ты хочешь узнать?");
        String question = input.nextLine();
        if (answer == 0) {
            text = "Да";
        } else if (answer == 1) {
            text = "Нет";
        } else {
            text = "Может быть";
        }
        System.out.println("Повелитель, вот мой ответ на твой вопрос: " + text);
    }
}
