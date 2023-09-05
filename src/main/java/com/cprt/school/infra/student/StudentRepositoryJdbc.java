package com.cprt.school.infra.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cprt.school.domain.information.CPF;
import com.cprt.school.domain.information.PhoneNumber;
import com.cprt.school.domain.student.Student;
import com.cprt.school.domain.student.StudentFactory;
import com.cprt.school.domain.student.StudentNotFoundException;
import com.cprt.school.domain.student.StudentRepository;

public class StudentRepositoryJdbc implements StudentRepository {

    private final Connection connection;

    public StudentRepositoryJdbc(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void register(Student student) {
        registerStudent(student);
        registerPhoneNumber(student.getPhoneNumbers());
    }

    private void registerStudent(Student student) {
        String sql = "INSERT INTO STUDENT VALUES(?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getCpf());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void registerPhoneNumber(List<PhoneNumber> phoneNumbers) {
        String sql = "INSERT INTO PHONE_NUMBER VALUES(?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (PhoneNumber phoneNumber : phoneNumbers) {
                preparedStatement.setString(1, phoneNumber.getDdd());
                preparedStatement.setString(1, phoneNumber.getNumber());
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student searchByCPF(CPF cpf) {
        try {
            String sql = "SELECT id, name, email FROM STUDENT WHERE cpf = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cpf.getCpf());

            ResultSet resultSet = preparedStatement.executeQuery();
            boolean isThereAnyStudentWithCpf = resultSet.next();
            if (!isThereAnyStudentWithCpf) {
                throw new StudentNotFoundException(cpf.getCpf());
            }

            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            StudentFactory studentFactory = new StudentFactory();
            studentFactory.withNameCpfAndEmail(name, cpf.getCpf(), email).getStudent();

            Long id = resultSet.getLong("id");
            sql = "SELECT ddd, number FROM PHONE_NUMBER WHERE student_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                studentFactory.withPhoneNumber(resultSet.getString("ddd"), resultSet.getString("number"));
            }
            resultSet.close();
            return studentFactory.getStudent();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> listAllStudents() {
        try {
            String sql = "SELECT id, name, email, cpf FROM STUDENT";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            List<Student> students = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String cpf = resultSet.getString("cpf");
                StudentFactory studentFactory = new StudentFactory();
                studentFactory.withNameCpfAndEmail(name, cpf, email).getStudent();

                Long id = resultSet.getLong("id");
                sql = "SELECT ddd, number FROM PHONE_NUMBER WHERE student_id = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, id);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    studentFactory.withPhoneNumber(resultSet.getString("ddd"), resultSet.getString("number"));
                }
                students.add(studentFactory.getStudent());
            }
            resultSet.close();
            return students;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
