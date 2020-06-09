package com.appstone.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private EditText mEtRegNo;
    private EditText mEtStudentName;
    private EditText mEtStudentBranch;
    private EditText mEtBookBorrowed;
    private EditText mEtIssueDate;
    private EditText mEtReturnDate;
    private Button mBtnEnterData;

    private DatabaseHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEtRegNo = findViewById(R.id.et_reg_no);
        mEtStudentName = findViewById(R.id.et_student_name);
        mEtStudentBranch = findViewById(R.id.et_student_branch);
        mEtBookBorrowed = findViewById(R.id.et_book_borrowed);
        mEtIssueDate = findViewById(R.id.et_issue_date);
        mEtReturnDate = findViewById(R.id.et_return_date);

        mBtnEnterData = findViewById(R.id.btn_enter_data);

        Button mBtnViewData = findViewById(R.id.btn_view_data);

        dbHelper = new DatabaseHelper(this);


        mBtnEnterData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String regNoVal = mEtRegNo.getText().toString();
                String studentName = mEtStudentName.getText().toString();
                String studentBranch = mEtStudentBranch.getText().toString();
                String bookborrowed = mEtBookBorrowed.getText().toString();
                String issueDate = mEtIssueDate.getText().toString();
                String returnDate = mEtReturnDate.getText().toString();
                int regNo = 0;
                if (!regNoVal.isEmpty()) {
                    regNo = Integer.parseInt(regNoVal);
                }

                Student studentDetails = new Student();
                studentDetails.regNo = regNo;
                studentDetails.studentName = studentName;
                studentDetails.studentBranch = studentBranch;
                studentDetails.bookborrowed = bookborrowed;
                studentDetails.issueDate = issueDate;
                studentDetails.returnDate = returnDate;

                dbHelper.insertDataToDatabase(studentDetails, dbHelper.getWritableDatabase());

                mEtRegNo.setText("");
                mEtStudentName.setText("");
                mEtStudentBranch.setText("");
                mEtBookBorrowed.setText("");
                mEtIssueDate.setText("");
                mEtReturnDate.setText("");
            }
        });


        mBtnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, StudentListActivity.class));
            }
        });
    }
}
