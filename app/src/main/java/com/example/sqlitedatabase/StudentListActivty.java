package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.sqlitedatabase.Adapter.StudentAdapter;
import com.example.sqlitedatabase.Adapter.TeacherAdapter;
import com.example.sqlitedatabase.DataBaseClass.DBmain;
import com.example.sqlitedatabase.Model.studentModel;
import com.example.sqlitedatabase.Model.teacherModel;

import java.util.ArrayList;

public class StudentListActivty extends AppCompatActivity {

    private ArrayList<studentModel> StudentList;
    private DBmain dbHandler;
    private StudentAdapter sAdapter;

public static RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list_activty);
        getSupportActionBar().setTitle("Student List");
        recyclerView = findViewById(R.id.StudentRecyclerView);

        StudentList = new ArrayList<>();
        getList1();

    }
    public void getList1(){
        dbHandler = new DBmain(StudentListActivty.recyclerView.getContext());

         StudentList = dbHandler.readCourses();


        sAdapter = new StudentAdapter(StudentList, StudentListActivty.this);

        recyclerView.setLayoutManager(new LinearLayoutManager(StudentListActivty.this ));
        recyclerView.setAdapter(sAdapter);

    }


}