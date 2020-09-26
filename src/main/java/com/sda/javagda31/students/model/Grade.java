package com.sda.javagda31.students.model;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double value; // 1, 2, 3, 4, 5

    @Enumerated(value = EnumType.STRING)
    private GradeSubject subject;

    @CreationTimestamp // now()
    private LocalDateTime datetimeCreated;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Student student;
}
