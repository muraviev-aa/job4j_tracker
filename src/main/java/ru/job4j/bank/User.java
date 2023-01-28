package ru.job4j.bank;

import java.util.Objects;

/**
 * Модель пользователя банка
 * @version 1.0
 * @author ALEKSEI MURAVIEV
 */
public class User {
    /**
     * Данные паспорта
     */
    private String passport;
    /**
     * Имя пользователя банка
     */
    private String username;

    /**
     * Конструктор класса User
     * @param passport данные паспорта
     * @param username имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Получаем данные паспорта
     * @return данные паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Принимаем данные паспорта
     * @param passport данные паспорта
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Получаем имя пользователя
     * @return имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Принимаем имя пользователя
     * @param username имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределенный метод equals
     * @param o объект для сравнения
     * @return возвращает true если объекты равны или false
     * если объекты не равны
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Переопределенный метод hashCode
     * @return идентификационный хеш
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
