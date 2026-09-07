package com.krishna.studentmanagement.mapper;

import org.springframework.stereotype.Component;

import com.krishna.studentmanagement.model.Student;
import com.krishna.studentmanagement.dto.CreateStudentRequest;
import com.krishna.studentmanagement.dto.StudentResponse;

@Component
public class StudentMapper 
{
    //CreateStudentRequest -> Student entity
    public Student toEntity(CreateStudentRequest request)
    {
        Student student = new Student();
        
        student.setName(request.getName());
        student.setAge(request.getAge());
        student.setCourse(request.getCourse());

        return student;
    }

    //student entity -> studenResponse
    public StudentResponse toResponse(Student student)
    {
        StudentResponse response = new StudentResponse();

        response.setId(student.getId());
        response.setName(student.getName());
        response.setAge(student.getAge());
        response.setCourse(student.getCourse());

        return response;
    }

    
}
