package com.sda.javagda31.students.service;


import com.sda.javagda31.students.model.Grade;
import com.sda.javagda31.students.repository.GradeRepository;
import org.springframework.stereotype.Service;

@Service
public class GradeService {
    private final GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public void update(Grade grade) {
        gradeRepository.save(grade);
    }

    public void deleteById(Long id) {
        gradeRepository.deleteById(id);
    }
}