package com.sda.javagda31.students.model;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Formula;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data // g s ts eqhs
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDate;

    @Formula("(year(now())-year(birth_date))")
    private Integer age;

    private boolean special;

    private double ects;

    @Formula("(SELECT AVG(g.value) from grade g where g.student_id=id)")
    private Double average;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @Cascade(value = org.hibernate.annotations.CascadeType.REMOVE)
    @EqualsAndHashCode.Exclude
    private Set<Grade> grades;
}
