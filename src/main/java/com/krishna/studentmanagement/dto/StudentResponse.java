package com.krishna.studentmanagement.dto;

public class StudentResponse 
{
    private int id;
    private String name;
    private int age;
    private String course;

    public void setName(String name)
    {
        this.name = name;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setCourse(String course)
    {
        this.course = course;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

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
