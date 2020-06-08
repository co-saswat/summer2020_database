package com.appstone.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    //ToDo this is the default constructor. We are going to do a constructor overloading to simplify our task.
//    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
//
//    }

    private static String TABLE_NAME = "students";
    private static String COL_REG_NO = "reg_no";
    private static String COL_STUDENT_NAME = "student_name";
    private static String COL_STUDENT_BRANCH = "student_branch";
    private static String COL_BOOK_BORROWED = "book_borrowed";
    private static String COL_ISSUE_DATE = "issue_date";
    private static String COL_RETURN_DATE = "return_date";


    //CREATE TABLE students(reg_no INTEGER PRIMARY KEY,student_name TEXT,student_branch TEXT,book_borrowed TEXT,issue_date TEXT,return_date TEXT)

    private static String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COL_REG_NO + " INTEGER PRIMARY KEY," + COL_STUDENT_NAME + " TEXT," +
            COL_STUDENT_BRANCH + " TEXT," + COL_BOOK_BORROWED + " TEXT," + COL_ISSUE_DATE + " TEXT," + COL_RETURN_DATE + " TEXT)";


    public DatabaseHelper(Context context) {
        super(context, "student_details.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertDataToDatabase(Student student, SQLiteDatabase database) {
        ContentValues cv = new ContentValues();
        cv.put(COL_REG_NO, student.regNo);
        cv.put(COL_STUDENT_NAME, student.studentName);
        cv.put(COL_STUDENT_BRANCH, student.studentBranch);
        cv.put(COL_BOOK_BORROWED, student.bookborrowed);
        cv.put(COL_ISSUE_DATE, student.issueDate);
        cv.put(COL_RETURN_DATE, student.returnDate);

        database.insert(TABLE_NAME, null, cv);
    }
}
