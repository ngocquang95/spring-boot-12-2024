package com.sqc.academy_c12.repository;

import com.sqc.academy_c12.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByNameContainingAndScoreBetween(String name, Double fromScore, Double toScore);

    @Query(value = """
            FROM Student WHERE name LIKE CONCAT('%', :name, '%')
            AND (:fromScore IS NULL OR score >= :fromScore)
             AND (:toScore IS NULL OR score <= :toScore)
            """)
    List<Student> findByAttr(String name, Double fromScore, Double toScore);

    @Query(value = """
            SELECT * FROM Student WHERE name LIKE CONCAT('%', :name, '%')
             AND (:fromScore IS NULL OR scorE >= :fromScore)
             AND (:toScore IS NULL OR score <= :toScore)
            """, nativeQuery = true)
    List<Student> findByAttrNativeQuery(String name, Double fromScore, Double toScore);
}
