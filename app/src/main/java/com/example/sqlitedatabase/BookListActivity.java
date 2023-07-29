package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;


import com.example.sqlitedatabase.Adapter.BookAdapter;
import com.example.sqlitedatabase.DataBaseClass.DBmain;
import com.example.sqlitedatabase.Model.bookModel;

import java.util.ArrayList;

public class BookListActivity extends AppCompatActivity  {
    private ArrayList<bookModel> List;
    private DBmain dbHandler;
    private BookAdapter mAdapter;
    private static RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);


        recyclerView = findViewById(R.id.BookRecyclerView);

        List = new ArrayList<>();
        getSupportActionBar().setTitle("Book List");
        getSupportActionBar().setTitle("kiran");
        Booklist();

    }

    public void Booklist() {
        dbHandler = new DBmain(BookListActivity.recyclerView.getContext());

        List = dbHandler.read1();

        mAdapter = new BookAdapter(BookListActivity.this, List);

        recyclerView.setLayoutManager(new LinearLayoutManager(BookListActivity.this));
        recyclerView.setAdapter(mAdapter);
    }

}