package com.krishna.studentmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;




@Entity
@Table(name = "students")
public class Student 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String course;

    //no arguments constructor
    public Student()
    {
    
    }

    //paramaterised constructor
    public Student(int id, String name, int age, String course)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    //setters
    public void setId(int id)
    {
        this.id = id;
    }

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
    public int getId()
    {
        return this.id;
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


