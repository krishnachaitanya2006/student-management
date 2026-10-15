package com.krishna.studentmanagement.service;

import org.springframework.stereotype.Service;

import com.krishna.studentmanagement.repository.StudentRepository;

import com.krishna.studentmanagement.model.Student;

import com.krishna.studentmanagement.dto.CreateStudentRequest;
import com.krishna.studentmanagement.dto.StudentResponse;
import com.krishna.studentmanagement.dto.UpdateStudentRequest;

import com.krishna.studentmanagement.exception.StudentNotFoundException;

import com.krishna.studentmanagement.mapper.StudentMapper;

//pagination
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;




@Service
public class StudentService
{
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    // Beans
    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper)
    {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }


    //add student
    public StudentResponse addStudent(CreateStudentRequest request)
    {
        //mapping request to student (to insert into db)
        Student student = studentMapper.toEntity(request);

       Student savedStudent = studentRepository.save(student);

        //mapping student into studentresponse(to send back the response after inserting)
       StudentResponse response = studentMapper.toResponse(student);

       
       return response;
    }

    // return all students
    public Page<Student> getAllStudents(Pageable pageable)
    {
        return studentRepository.findAll(pageable);
    }

    //finding by name
    public List<StudentResponse> findByName(String name)
    {
        List<Student> students = studentRepository.findByName(name);

        List<StudentResponse> responses = new ArrayList<>();

        for(Student item : students)
        {
            StudentResponse response = studentMapper.toResponse(item);

            responses.add(response);
        }

        return responses;
    }

    //find by id
    public Student findById(int id)
    {
        //Optional<Student> optional = studentRepository.findById(id);
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("student not found"));

        return student;

    }

    //deleting a student
    public void deleteStudent(int id)
    {
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("studnt not found"));

        studentRepository.delete(student);
    }

    //updating a student
    public StudentResponse updateStudent(int id, UpdateStudentRequest updatedStudent)
    {
        Student student = studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("student not found"));

        student.setName(updatedStudent.getName());
        student.setAge(updatedStudent.getAge());
        student.setCourse(updatedStudent.getCourse());

        Student savedStudent = studentRepository.save(student);

        StudentResponse response = studentMapper.toResponse(savedStudent);

        return response;
    }

    //find by nameContaining
    public Page<StudentResponse> findByNameContaining(String name, Pageable pageable) {

        Page<Student> students = studentRepository.findByNameContaining(name, pageable);

        
        return students.map(studentMapper::toResponse);

    }

    //find by course
    public List<StudentResponse> findByCourse(String course) {

        List<Student> students = studentRepository.findByCourse(course);

        List<StudentResponse> response = new ArrayList<>();

        for(Student student : students) {

            response.add(studentMapper.toResponse(student));
        }

        return response;

    }

    public Page<StudentResponse> findByNameContainingAndCourse(String name, String course, Pageable pageable) {

        Page<Student> students = studentRepository.findByNameContainingAndCourse(name, course, pageable);

        //List<StudentResponse> response = new ArrayList<>();

        return students.map(studentMapper::toResponse);
    }


    
}
