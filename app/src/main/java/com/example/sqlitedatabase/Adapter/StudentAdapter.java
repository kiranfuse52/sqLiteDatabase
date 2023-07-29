package com.example.sqlitedatabase.Adapter;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlitedatabase.DataBaseClass.DBmain;
import com.example.sqlitedatabase.Model.studentModel;
import com.example.sqlitedatabase.R;
import com.example.sqlitedatabase.StudentListActivty;


import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {


        //variable for array list and context
        private final ArrayList<studentModel> studentList;
        Context context;
//        StudentListActivty studentListActivty;

        //constructor
        public StudentAdapter(ArrayList<studentModel> studentList, Context context) {
            this.studentList = studentList;
            this.context = context;
    }

    @NonNull
    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_row, parent, false);
        return new ViewHolder(view);

    }
    @SuppressLint({"MissingInflatedId", "RecyclerView"})
    public void onBindViewHolder(@NonNull StudentAdapter.ViewHolder holder,  int position) {
        studentModel model = studentList.get(position);
        holder.sname.setText(model.getStudent_name());
        holder.sclass.setText(model.getStudent_Class());


        DBmain db=new DBmain(holder.id.getContext());
        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater linf = LayoutInflater.from(context);
                final View inflator = linf.inflate(R.layout.student_dialog, null);
                AlertDialog.Builder alert = new AlertDialog.Builder(context);

                alert.setTitle("ID " + studentList.get(position).getId());
                alert.setView(inflator);

                 final EditText et4 = (EditText) inflator.findViewById(R.id.StudentN);
                final EditText et5 = (EditText) inflator.findViewById(R.id.StudentC);


                alert.setPositiveButton("add", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        String name=et4.getText().toString();
                        String classs=et5.getText().toString();

                        db.UpdateData(name,classs,studentList.get(position).getId());
                        StudentListActivty studentListActivty1=new StudentListActivty();

                        studentListActivty1.getList1();
                        Toast.makeText(context, "kiran", Toast.LENGTH_SHORT).show();

                    }
                });
                alert.show();
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alert = new AlertDialog.Builder(view.getContext());
                AlertDialog dialog = alert.create();
                alert.setTitle("Are you sure want to delete this " + studentList.get(position).getId());
                alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        db.deleteStudentRecord(studentList.get(position).getId());
                        studentList.remove(position);
                        notifyItemRemoved(position);

                    }
                });

                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialog.cancel();
                    }
                });
                alert.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
            TextView sname,sclass,id;
            ImageView update,delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.ID);
            sname=itemView.findViewById(R.id.SName);
            sclass=itemView.findViewById(R.id.SClass);
            update=itemView.findViewById(R.id.Update);
            delete=itemView.findViewById(R.id.Delete);
        }
    }
}
