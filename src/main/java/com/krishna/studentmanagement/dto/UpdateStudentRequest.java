package com.krishna.studentmanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;

public class UpdateStudentRequest {

    @NotBlank(message = "name cannot be blank")
    private String name;
    @Min(value = 1, message = "age cannot be less than 1")
    private int age;
    @NotBlank(message="course cannot be blank")
    private String course;

    //setters
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

    //getters
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
        return  this.course;
    }
}
