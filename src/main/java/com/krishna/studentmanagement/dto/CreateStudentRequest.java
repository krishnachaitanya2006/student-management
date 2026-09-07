package com.krishna.studentmanagement.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class CreateStudentRequest 
{
    @NotBlank(message="name cannot be blank")
    private String name;

    @Min(value = 1, message="age cannot be less that 1")
    private int age;

    @NotBlank(message="course cannot be empty")
    private String course;

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setCourse(String course)
    {
        this.course = course;
    }

    public String getName()
    {
        return this.name;
    }

    public int getAge()
    {
        return this.age;
    }

    public String getCourse()
    {
        return this.course;
    }
    
}
