package com.example.sqlitedatabase.Model;

public class teacherModel {
    long id;
    String Teacher_name,Teacher_sub;

    public teacherModel(long id, String teacher_name, String teacher_sub) {
        this.id = id;
        this.Teacher_name = teacher_name;
       this. Teacher_sub = teacher_sub;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTeacher_name() {
        return Teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        Teacher_name = teacher_name;
    }

    public String getTeacher_sub() {
        return Teacher_sub;
    }

    public void setTeacher_sub(String teacher_sub) {
        Teacher_sub = teacher_sub;
    }
}
