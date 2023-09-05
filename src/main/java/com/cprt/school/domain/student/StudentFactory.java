package com.cprt.school.domain.student;

import com.cprt.school.domain.information.CPF;
import com.cprt.school.domain.information.Email;

public class StudentFactory {

    private Student student;

    public StudentFactory withNameCpfAndEmail(String name, String cpf, String email){
        this.student = new Student(name, new CPF(cpf), new Email(email));
        return this;
    }

    public StudentFactory withPhoneNumber(String ddd, String number){
        this.student.addNewPhoneNumber(ddd, number);
        return this;
    }

    public Student getStudent() {
        return student;
    }

    
    
}
