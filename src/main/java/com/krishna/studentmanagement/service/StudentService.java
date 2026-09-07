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
import java.util.Optional;


@Service
public class StudentService
{
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

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


    
}
