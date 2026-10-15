package com.krishna.studentmanagement.repository;

//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.krishna.studentmanagement.model.Student;
import java.util.List;

//pagnation
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
// Pageable = tells Spring Data what to fetch
// Page<User> = contains what was fetched + metadata

public interface StudentRepository extends JpaRepository<Student, Integer>
{
    List<Student> findByName(String name);

    Page<Student> findByNameContaining(String name, Pageable pageable);

    List<Student> findByCourse(String course);

    Page<Student> findByNameContainingAndCourse(String name, String course, Pageable page);
    
}
