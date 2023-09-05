package com.cprt.school.domain.student;

import java.util.List;

import com.cprt.school.domain.information.CPF;

public interface StudentRepository {
    
    void register(Student student);

    Student searchByCPF(CPF cpf);

    List<Student> listAllStudents();

}
