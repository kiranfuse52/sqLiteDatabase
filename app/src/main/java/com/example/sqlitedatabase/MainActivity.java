package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlitedatabase.DataBaseClass.DBmain;

public class MainActivity extends AppCompatActivity {
EditText S_name,S_Class,T_name,T_sub,B_name,B_publisher;
Button S_save,S_list,T_save,T_list,B_save,B_list;
DBmain db;
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBmain(this);

        S_name=findViewById(R.id.Student_name);
        S_Class=findViewById(R.id.Student_class);

        T_name=findViewById(R.id.Teacher_Name);
        T_sub=findViewById(R.id.Teacher_Sub);

        B_publisher=findViewById(R.id.Book_Publisher);
        B_name=findViewById(R.id.Book_name);

        S_save=findViewById(R.id.Save);
        S_list=findViewById(R.id.List);

        T_save=findViewById(R.id.TSave);
        T_list=findViewById(R.id.TList);

        B_save=findViewById(R.id.BSave);
        B_list=findViewById(R.id.BList);

        S_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String StudentN=S_name.getText().toString();
                String StudentC=S_Class.getText().toString();
                if(StudentN.isEmpty() && StudentC.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please add data", Toast.LENGTH_SHORT).show();
                }else {
                    db.insertData(StudentN, StudentC);
                    S_name.setText("");
                    S_Class.setText("");
                }
            }
        });
        S_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, StudentListActivty.class));

            }
        });

        T_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String TeacherN=T_name.getText().toString();
                String TeacherS=T_sub.getText().toString();
                if(TeacherN.isEmpty() && TeacherS.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please add data", Toast.LENGTH_SHORT).show();
                }else{
                    db.Data(TeacherN, TeacherS);
                    T_name.setText("");
                    T_sub.setText("");
                }


            }
        });

        T_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, TeacherListActivity.class));

            }
        });

        B_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String BookN=B_publisher.getText().toString();
                String BookP=B_name.getText().toString();
                if(BookN.isEmpty() && BookP.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please add data", Toast.LENGTH_SHORT).show();
                }else{
                    db.insert(BookN, BookP);
                    B_publisher.setText("");
                    B_name.setText("");

                }
            }
        });

        B_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BookListActivity.class));

            }
        });
    }
}