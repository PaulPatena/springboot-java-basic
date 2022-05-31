package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {

    // since we constructed the function name from a pattern, SQL will automatically generated for you
    // SELECT * FROM student where email = ?
    // Another approach is annotating directly
    @Query("SELECT s FROM Student s WHERE s.email = ?1")  // Student (capital) refers to the Entity in Student class
    Optional<Student> findStudentByEmail(String email);

}
