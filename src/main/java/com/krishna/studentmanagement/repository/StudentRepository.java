package com.krishna.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.krishna.studentmanagement.model.Student;
import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Integer>
{
    List<Student> findByName(String name);
    
}
