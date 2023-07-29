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

import com.example.sqlitedatabase.BookListActivity;
import com.example.sqlitedatabase.DataBaseClass.DBmain;
import com.example.sqlitedatabase.Model.bookModel;
import com.example.sqlitedatabase.R;
import com.example.sqlitedatabase.bookinterface;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    @NonNull
    Context context;
    ArrayList<bookModel>BookList;


   BookListActivity bookListActivity =new BookListActivity();

    public BookAdapter(@NonNull Context context, ArrayList<bookModel> bookList) {
        this.context = context;
        this.BookList = bookList;

    }

    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_row, parent, false);
        return new BookAdapter.ViewHolder(view);
    }
    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull BookAdapter.ViewHolder holder,int position) {

        bookModel model = BookList.get(position);
        holder.bname.setText(model.getBook_name());
        holder.bpublisher.setText(model.getBook_publisher());

        DBmain db=new DBmain(holder.id.getContext());

        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater linf = LayoutInflater.from(context);
                final View inflator = linf.inflate(R.layout.student_dialog, null);
                AlertDialog.Builder alert = new AlertDialog.Builder(context);

                alert.setTitle("ID " + BookList.get(position).getId());
                alert.setView(inflator);

                final EditText et4 = (EditText) inflator.findViewById(R.id.StudentN);
                final EditText et5 = (EditText) inflator.findViewById(R.id.StudentC);


                alert.setPositiveButton("add", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        String name=et4.getText().toString();
                        String classs=et5.getText().toString();


                        db.UpdateBook(name,classs,BookList.get(position).getId());


                bookListActivity.Booklist();



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
                alert.setTitle("Are you sure want to delete this " + BookList.get(position).getId());
                alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        db.deleteBook(BookList.get(position).getId());
                        BookList.remove(position);
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

        return BookList.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView bname,bpublisher,id;
        ImageView update,delete;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            id=itemView.findViewById(R.id.ID);
            bname=itemView.findViewById(R.id.BName);
            bpublisher=itemView.findViewById(R.id.BPublisher);

            update=itemView.findViewById(R.id.Update);
            delete=itemView.findViewById(R.id.Delete);
        }
    }
}
