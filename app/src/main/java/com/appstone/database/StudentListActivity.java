package com.appstone.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class StudentListActivity extends AppCompatActivity {

    /**
     * There are three types of RecyclerViews
     * <p>
     * 1. LinearLayout
     * 2. GridLayout
     * 3. StaggeredGridLayout
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        RecyclerView mRcStudentList = findViewById(R.id.rc_student_list);
        mRcStudentList.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

//        mRcStudentList.setLayoutManager(new GridLayoutManager(this, 2));
//        mRcStudentList.setLayoutManager(new StaggeredGridLayoutManager(3, RecyclerView.VERTICAL));

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        ArrayList<Student> students = dbHelper.getDataFromDatabase(dbHelper.getReadableDatabase());

        StudentListAdapter adapter = new StudentListAdapter(this, students);
        mRcStudentList.setAdapter(adapter);
    }
}
