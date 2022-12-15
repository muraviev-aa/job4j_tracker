package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book = new Book("Stroll", 10);
        Book book1 = new Book("Bounce", 15);
        Book book2 = new Book("Horse", 12);
        Book book3 = new Book("Clean code", 50);
        Book[] bks = new Book[4];
        bks[0] = book;
        bks[1] = book1;
        bks[2] = book2;
        bks[3] = book3;
        for (int index = 0; index < bks.length; index++) {
            Book bk = bks[index];
            System.out.println(bk.getName() + " - " + bk.getNumber());
        }
        System.out.println("-------------");
        System.out.println("Replace [0] and [3].");
        Book book4;
        book4 = bks[0];
        bks[0] = bks[3];
        bks[3] = book4;
        for (int index = 0; index < bks.length; index++) {
            Book bk = bks[index];
            System.out.println(bk.getName() + " - " + bk.getNumber());
        }
        System.out.println("-------------");
        System.out.println("Output of books named Clean code");
        for (int index = 0; index < bks.length; index++) {
            Book bk = bks[index];
            if ("Clean code".equals(bk.getName())) {
                System.out.println(bk.getName() + " - " + bk.getNumber());
            }
        }
    }
}
