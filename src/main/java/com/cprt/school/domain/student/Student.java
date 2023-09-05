package com.cprt.school.domain.student;

import java.util.ArrayList;
import java.util.List;

import com.cprt.school.domain.information.CPF;
import com.cprt.school.domain.information.Email;
import com.cprt.school.domain.information.PhoneNumber;

public class Student {

    private CPF cpf;
    private String name;
    private Email email;
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();

    public Student(String name, CPF cpf, Email email) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

    public void addNewPhoneNumber(String ddd, String phoneNumber) {
        this.phoneNumbers.add(new PhoneNumber(ddd, phoneNumber));
    }

    public String getCpf() {
        return this.cpf.getCpf();
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email.getEmail();
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return this.phoneNumbers;
    }

    

}
