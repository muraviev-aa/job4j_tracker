package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> predicateName = s -> s.getName().contains(key);
        Predicate<Person> predicateSurname = s -> s.getSurname().contains(key);
        Predicate<Person> predicatePhone = s -> s.getPhone().contains(key);
        Predicate<Person> predicateAddress = s -> s.getAddress().contains(key);
        Predicate<Person> combine = predicateName.or(predicateSurname).
                or(predicatePhone).or(predicateAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
