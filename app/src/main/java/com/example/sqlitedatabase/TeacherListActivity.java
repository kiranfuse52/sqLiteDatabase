package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.sqlitedatabase.Adapter.BookAdapter;
import com.example.sqlitedatabase.Adapter.TeacherAdapter;
import com.example.sqlitedatabase.DataBaseClass.DBmain;
import com.example.sqlitedatabase.Model.bookModel;
import com.example.sqlitedatabase.Model.teacherModel;

import java.util.ArrayList;

public class TeacherListActivity extends AppCompatActivity {

    static ArrayList<teacherModel> TeacherList;
    static DBmain dbHandler;
    static TeacherAdapter tAdapter;
static RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_list2);

        recyclerView=findViewById(R.id.TeacherRecyclerView);

        TeacherList = new ArrayList<>();
        getList();

    }

    public static void getList() {
        dbHandler = new DBmain(TeacherListActivity.recyclerView.getContext());

        TeacherList = dbHandler.read();


        tAdapter = new TeacherAdapter(TeacherListActivity.recyclerView.getContext(), TeacherList);

        recyclerView.setLayoutManager(new LinearLayoutManager(TeacherListActivity.recyclerView.getContext() ));
        recyclerView.setAdapter(tAdapter);
    }
}