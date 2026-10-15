package com.krishna.studentmanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

//params
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

//for rest controller
import org.springframework.web.bind.annotation.RestController;

//for validating the incoming data
import jakarta.validation.Valid;

//for student and studentservice objects, update
import com.krishna.studentmanagement.model.Student;
import com.krishna.studentmanagement.service.StudentService;
import com.krishna.studentmanagement.dto.UpdateStudentRequest;

import  com.krishna.studentmanagement.dto.CreateStudentRequest;
import  com.krishna.studentmanagement.dto.StudentResponse;

//pagination
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;


@RestController
public class StudentController {


    private final StudentService studentService;

    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }


    @GetMapping("/")
    public String home()
    {
        return "student management System";
    }

    
    //return all students
    @GetMapping("/students")
    public Page<Student> getAllStudents(Pageable pageable)
    {
        return studentService.getAllStudents(pageable);
    }


    //adding a student
    @PostMapping("/students")
    public StudentResponse addStudent(@Valid @RequestBody CreateStudentRequest request)
    {
        return studentService.addStudent(request);
    }

    // ------------------------------------------------------------------------------------- //

    // SEARCHING
    //search by id
    @GetMapping("/students/{id}")
    public Student findById(@PathVariable int id)
    {
        return studentService.findById(id);
    }

    //search by name
    @GetMapping("/students/search/name/{name}")
    public List<StudentResponse> findByName(@PathVariable String name)
    {
        return studentService.findByName(name);
    }

    //searching by nameContaining
    @GetMapping("/students/search/contains/name/{name}")
    public Page<StudentResponse> findByNameContaining(@PathVariable String name, Pageable pageable) {

        return studentService.findByNameContaining(name, pageable);

    }

    //search by course
    @GetMapping("/students/search/course/{course}")
    public List<StudentResponse> findByCourse(@PathVariable String course) {

        return studentService.findByCourse(course);
    }

    //search by name and course
    @GetMapping("/students/search")
    public Page<StudentResponse> findByNameContainingAndCourse(
            @RequestParam String name,
            @RequestParam String course,
            Pageable pageable) {


                return studentService.findByNameContainingAndCourse(name, course, pageable);
            }
    // ------------------------------------------------------------------------------ //

    //deleting a student
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable int id)
    {
        studentService.deleteStudent(id);
    }

    //updating a student
    @PutMapping("/students/{id}")
    public StudentResponse updateStudent(
        @PathVariable int id,
        @Valid @RequestBody UpdateStudentRequest updatedStudent)
    {
        return studentService.updateStudent(id, updatedStudent);
    }
}
