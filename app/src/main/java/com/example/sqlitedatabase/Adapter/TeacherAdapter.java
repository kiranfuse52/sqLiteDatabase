package com.example.sqlitedatabase.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlitedatabase.DataBaseClass.DBmain;
import com.example.sqlitedatabase.Model.studentModel;
import com.example.sqlitedatabase.Model.teacherModel;
import com.example.sqlitedatabase.R;
import com.example.sqlitedatabase.StudentListActivty;
import com.example.sqlitedatabase.TeacherListActivity;

import java.util.ArrayList;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.ViewHolder> {
    @NonNull
    Context context;
    ArrayList<teacherModel>TeacherList;
  TeacherListActivity teacherListActivity=new TeacherListActivity();

    public TeacherAdapter( Context context, ArrayList<teacherModel> teacherList) {

        this.context = context;
        this.TeacherList = teacherList;
    }

    @Override
    public TeacherAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_row, parent, false);
        return new TeacherAdapter.ViewHolder(view);

    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull TeacherAdapter.ViewHolder holder, int position) {
       teacherModel model = TeacherList.get(position);
        holder.tname.setText(model.getTeacher_name());
        holder.tsub.setText(model.getTeacher_sub());

        DBmain db=new DBmain(holder.id.getContext());
        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater linf = LayoutInflater.from(context);
                final View inflator = linf.inflate(R.layout.student_dialog, null);
                AlertDialog.Builder alert = new AlertDialog.Builder(context);

                alert.setTitle(" ID " + TeacherList.get(position).getId());
                alert.setView(inflator);

                final EditText et4 = (EditText) inflator.findViewById(R.id.StudentN);
                final EditText et5 = (EditText) inflator.findViewById(R.id.StudentC);


                alert.setPositiveButton("add", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        String name=et4.getText().toString();
                        String classs=et5.getText().toString();

                        db.UpdateTeacher(name,classs,TeacherList.get(position).getId());
                       teacherListActivity.getList();

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
                alert.setTitle("Are you sure want to delete this " + TeacherList.get(position).getId());
                alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        db.deleteTeacher(TeacherList.get(position).getId());
                        TeacherList.remove(position);
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
        return TeacherList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tname,tsub,id;
        ImageView update,delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            id=itemView.findViewById(R.id.ID);
            tname= itemView.findViewById(R.id.SName);
            tsub=itemView.findViewById(R.id.SClass);

            update=itemView.findViewById(R.id.Update);
            delete=itemView.findViewById(R.id.Delete);



        }
    }
}

