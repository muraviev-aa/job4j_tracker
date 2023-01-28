package ru.job4j.bank;

import java.util.Objects;

/**
 * Модель банковского счета
 * @autor ALEKSEI MURAVIEV
 * @version 1.0
 */
public class Account {
    /**
     * поле реквизиты
     */
    private String requisite;
    /**
     * поле баланс
     */
    private double balance;

    /**
     * Конструктор класса Account
     * @param requisite
     * @param balance
     */

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Получаем реквизит
     * @return возвращает строку реквизит
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Принимаем реквизит
     * @param requisite реквизит
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Получаем баланс
     * @return баланс
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Принимаем баланс
     * @param balance
     */

    public void setBalance(double balance) {
        this.balance = balance;
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределенный метод hashCode
     * @return идентификационный хеш
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
