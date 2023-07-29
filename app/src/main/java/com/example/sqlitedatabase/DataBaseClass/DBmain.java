package com.example.sqlitedatabase.DataBaseClass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.sqlitedatabase.Model.bookModel;
import com.example.sqlitedatabase.Model.studentModel;
import com.example.sqlitedatabase.Model.teacherModel;

import java.security.AccessController;
import java.util.ArrayList;

public class DBmain extends SQLiteOpenHelper {
    static final String DB_NAME = "BookDatabase";
    public static final int DB_Version = 7;
    public static final String TABLE_NAME = "StudentList";
    public static final String STUDENT_NAME = "Name";
    public static final String STUDENT_CLASS = "Class";
    public static final String TABLE_NAME1 = "TeacherList";
    public static final String TEACHER_NAME = "Tname";
    public static final String TEACHER_SUB = "sub";

    public static final String TABLE_NAME2 = "BookList";
    public static final String BOOK_NAME = "Bname";
    public static final String bOOK_PUBLISHER = "publisher";
    public static final String ID = "id";
    private AccessController rootView;

    public DBmain(@Nullable Context context) {
        super(context, DB_NAME, null, 8);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String res = "CREATE TABLE "
                + TABLE_NAME + " ("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + STUDENT_NAME + " TEXT, "
                + STUDENT_CLASS + "  TEXT)";

        String res1 = "CREATE TABLE "
                + TABLE_NAME1 + " ("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TEACHER_NAME + " TEXT, "
                + TEACHER_SUB + "  TEXT)";

        String res2 = "CREATE TABLE "
                + TABLE_NAME2 + " ("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + BOOK_NAME + " TEXT, "
                + bOOK_PUBLISHER + "  TEXT)";
        sqLiteDatabase.execSQL(res);
        sqLiteDatabase.execSQL(res1);
        sqLiteDatabase.execSQL(res2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);

        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

    public void insertData(String StudentName, String StudentClass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(STUDENT_NAME, StudentName);
        values.put(STUDENT_CLASS, StudentClass);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void UpdateData(String StudentName, String StudentClass, long id) {
        SQLiteDatabase db = getWritableDatabase();

        // Define the values to update
        ContentValues values = new ContentValues();
        if (StudentName != null) {
            values.put(STUDENT_NAME, StudentName);
        }
        if (StudentClass != null) {
            values.put(STUDENT_CLASS, StudentClass);
        }

        // Update the record
        int rowsUpdated = db.update(TABLE_NAME, values, ID + " = ?", new String[]{String.valueOf(id)});

        // Print the number of rows updated
        Log.d("DatabaseHelper", "Updated " + rowsUpdated + " rows");

        // Close the database
        db.close();

    }

    public void deleteStudentRecord(long id) {
        // Get a writable database
        SQLiteDatabase db = getWritableDatabase();

        // Delete the record with the specified ID
        int rowsDeleted = db.delete(TABLE_NAME, ID + " = ?", new String[]{String.valueOf(id)});

        // Print the number of rows deleted
        Log.d("DatabaseHelper", "Deleted " + rowsDeleted + " rows");

        // Close the database
        db.close();
    }

    public void Data(String TeacherName, String TeacherSub) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values1 = new ContentValues();

        values1.put(TEACHER_NAME, TeacherName);
        values1.put(TEACHER_SUB, TeacherSub);

        db.insert(TABLE_NAME1, null, values1);
        db.close();
    }

    public void UpdateTeacher(String TeacherName, String TeacherSub, long id) {
        SQLiteDatabase db = getWritableDatabase();

        // Define the values to update
        ContentValues values = new ContentValues();
        if (TeacherName != null) {
            values.put(TEACHER_NAME, TeacherName);
        }
        if (TeacherSub != null) {
            values.put(TEACHER_SUB, TeacherSub);
        }

        // Update the record
        int rowsUpdated = db.update(TABLE_NAME1, values, ID + " = ?", new String[]{String.valueOf(id)});

        // Print the number of rows updated
        Log.d("DatabaseHelper", "Updated " + rowsUpdated + " rows");

        // Close the database
        db.close();
    }

    public void deleteTeacher(long id) {
        // Get a writable database
        SQLiteDatabase db = getWritableDatabase();

        // Delete the record with the specified ID
        int rowsDeleted = db.delete(TABLE_NAME1, ID + " = ?", new String[]{String.valueOf(id)});

        // Print the number of rows deleted
        Log.d("DatabaseHelper", "Deleted " + rowsDeleted + " rows");

        // Close the database
        db.close();
    }

    public void insert(String Bookname, String Bookpublisher) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values2 = new ContentValues();

        values2.put(BOOK_NAME, Bookname);
        values2.put(bOOK_PUBLISHER, Bookpublisher);

        db.insert(TABLE_NAME2, null, values2);
        db.close();
    }

    public void UpdateBook(String Bookname, String Bookpublisher, long id) {
        SQLiteDatabase db = getWritableDatabase();

        // Define the values to update
        ContentValues values = new ContentValues();
        if (Bookname != null) {
            values.put(BOOK_NAME, Bookname);
        }
        if (Bookpublisher != null) {
            values.put(bOOK_PUBLISHER, Bookpublisher);
        }

        // Update the record
        int rowsUpdated = db.update(TABLE_NAME2, values, ID + " = ?", new String[]{String.valueOf(id)});

        // Print the number of rows updated
        Log.d("DatabaseHelper", "Updated " + rowsUpdated + " rows");

        // Close the database
        db.close();
    }




    public void deleteBook(long id) {
        // Get a writable database
        SQLiteDatabase db = getWritableDatabase();

        // Delete the record with the specified ID
        int rowsDeleted = db.delete(TABLE_NAME2, ID + " = ?", new String[] { String.valueOf(id) });

        // Print the number of rows deleted
        Log.d("DatabaseHelper", "Deleted " + rowsDeleted + " rows");

        // Close the database
        db.close();
    }

    public ArrayList<studentModel> readCourses(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses1 = db.rawQuery(" SELECT * FROM " + TABLE_NAME, null);

        ArrayList<studentModel>courseModalArrayList=new ArrayList<>();

        if (cursorCourses1.moveToFirst()) {
            do {
                courseModalArrayList.add(new studentModel(
                        cursorCourses1.getLong(0),
                        cursorCourses1.getString(1),
                        cursorCourses1.getString(2)
                ));
            } while (cursorCourses1.moveToNext());
        }
        cursorCourses1.close();
        return courseModalArrayList;
    }

        public ArrayList<teacherModel>read(){
            SQLiteDatabase db = this.getReadableDatabase();

            Cursor cursorCourses1 = db.rawQuery(" SELECT * FROM " + TABLE_NAME1, null);

            ArrayList<teacherModel>courseModalArrayList1=new ArrayList<>();

            if (cursorCourses1.moveToFirst()) {
                do {
                    courseModalArrayList1.add(new teacherModel(
                            cursorCourses1.getLong(0),
                            cursorCourses1.getString(1),
                            cursorCourses1.getString(2)
                    ));
                } while (cursorCourses1.moveToNext());
            }
            cursorCourses1.close();
            return courseModalArrayList1;
        }
    public ArrayList<bookModel>read1(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses2 = db.rawQuery(" SELECT * FROM " + TABLE_NAME2, null);

        ArrayList<bookModel>courseModalArrayList2=new ArrayList<>();

        if (cursorCourses2.moveToFirst()) {
            do {
                courseModalArrayList2.add(new bookModel(
                        cursorCourses2.getLong(0),
                        cursorCourses2.getString(1),
                        cursorCourses2.getString(2)
                ));
            } while (cursorCourses2.moveToNext());
        }
        cursorCourses2.close();
        return courseModalArrayList2;
    }

    }
