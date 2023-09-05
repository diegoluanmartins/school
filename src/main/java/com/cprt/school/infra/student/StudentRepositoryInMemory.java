package com.cprt.school.infra.student;

import java.util.ArrayList;
import java.util.List;

import com.cprt.school.domain.information.CPF;
import com.cprt.school.domain.student.Student;
import com.cprt.school.domain.student.StudentNotFoundException;
import com.cprt.school.domain.student.StudentRepository;

public class StudentRepositoryInMemory implements StudentRepository {

    private List<Student> students = new ArrayList<>();

    @Override
    public void register(Student student) {
        this.students.add(student);
    }

    @Override
    public Student searchByCPF(CPF cpf) {
        Student student = students.stream().filter(s -> s.getCpf().equals(cpf.getCpf())).findFirst().orElseThrow(() -> new StudentNotFoundException(cpf.getCpf()));
        return student;
    }

    @Override
    public List<Student> listAllStudents() {
        return this.students;
    }
    
}
