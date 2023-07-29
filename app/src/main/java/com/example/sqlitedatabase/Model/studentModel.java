package com.example.sqlitedatabase.Model;

public class studentModel {
    long id;
    String Student_name, Student_Class;

    public studentModel(long id, String student_name, String student_Class) {
        this.id = id;
       this. Student_name = student_name;
       this. Student_Class = student_Class;
    }

    public String getStudent_name() {
        return Student_name;
    }

    public void setStudent_name(String student_name) {
        Student_name = student_name;
    }

    public String getStudent_Class() {
        return Student_Class;
    }

    public void setStudent_Class(String student_Class) {
        Student_Class = student_Class;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

