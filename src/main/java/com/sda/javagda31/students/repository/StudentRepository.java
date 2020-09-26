package com.sda.javagda31.students.repository;

import com.sda.javagda31.students.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// DAO - find, findbyid, findAll, save, delete, deleteById ... (CRUD)
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findAllByFirstNameLike(String phrase);
    List<Student> findAllByFirstNameLikeAndLastNameLike(String phrase, String lastPhrase);
}
