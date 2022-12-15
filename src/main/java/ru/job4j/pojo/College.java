package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setStudent("Muraviev Aleksey Aleksandrovich");
        student.setGroup("trainee");
        student.setAdmission(new Date());

        System.out.println("Student: " + student.getStudent()
                + "\ngroup: " + student.getGroup()
                + "\ndate admission: " + student.getAdmission());
    }
}
