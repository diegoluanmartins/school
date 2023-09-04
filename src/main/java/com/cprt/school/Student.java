package com.cprt.school;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private CPF cpf;
    private String name;
    private Email email;
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();

    public Student(CPF cpf, String name, Email email) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    public void addNewPhoneNumber(String ddd, String phoneNumber) {
        this.phoneNumbers.add(new PhoneNumber(ddd, phoneNumber));
    }

}
