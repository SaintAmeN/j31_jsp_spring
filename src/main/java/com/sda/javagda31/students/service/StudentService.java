package com.sda.javagda31.students.service;

import com.sda.javagda31.students.controller.StudentController;
import com.sda.javagda31.students.model.Student;
import com.sda.javagda31.students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// DependencyInjection mechanism

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired // inject
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public void delete(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    public Optional<Student> findStudent(Long studentId) {
        return studentRepository.findById(studentId);
    }
}
