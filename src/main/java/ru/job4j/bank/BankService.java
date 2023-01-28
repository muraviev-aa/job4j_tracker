package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Главный сервис
 * @author ALEKSEI MURAVIEV
 * @version 1.0
 */
public class BankService {
    /**
     * Поле содержит всех пользователей системы с привязанными к ним счетами
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему
     * @param user пользователь
     */

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод, удаляющий пользователя из системы
     * @param passport данные паспорта
     * @return возвращает true если пользователь удален или false
     * если пользователь не удален
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод добляет новый счет к пользователю
     * @param passport данные паспорта
     * @param account данные аккаунта
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> ac = getAccounts(user);
            if (!ac.contains(account)) {
                ac.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта
     * @param passport данные паспорта
     * @return пользователя
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет счет пользователя по реквизитам
     * @param passport данные паспорта
     * @param requisite данные реквизита
     * @return
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = getAccounts(user);
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт
     * проверка на наличие в хранилище карточки списания
     * проверка на наличие в хранилище карточки назначения
     * проверка на положительную разницу сумм переводов
     * @param srcPassport паспорт карточки списания
     * @param srcRequisite реквизиты счёта списания
     * @param destPassport паспорт карточки назначения
     * @param destRequisite реквизиты счёта назначения
     * @param amount сумма к переводу
     * @return Если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят),
     * то метод должен вернуть false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        boolean rsl = srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount;
        if (rsl) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
        }
        return rsl;
    }

    /**
     * Метод получает аккаунты
     * @param user пользователь
     * @return список аккаунтов
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
