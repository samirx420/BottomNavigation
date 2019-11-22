package com.samir.assignment3.ui;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.samir.assignment3.R;
import com.samir.assignment3.Student.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends Fragment implements View.OnClickListener {
    String Gender, Age, Address, UserName;
    static List<Student> studentList = new ArrayList<>();
    EditText etAge, etName, etAddress;
    RadioButton rmale, rfemale, rothers;
    RadioGroup rg;
    Button btnSave;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_add, container, false);
        etAge = view.findViewById(R.id.age);
        etName = view.findViewById(R.id.username);
        etAddress = view.findViewById(R.id.address);
        rmale = view.findViewById(R.id.rbMale);
        rfemale = view.findViewById(R.id.rbFemale);
        rothers = view.findViewById(R.id.rbOthers);
        rg = view.findViewById(R.id.rg);
        btnSave = view.findViewById(R.id.save);
        btnSave.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:
                UserName = etName.getText().toString().trim();
                Address = etAddress.getText().toString().trim();
                Age = etAge.getText().toString().trim();

                // Toast.makeText(getActivity(), ""+UserName+Age+Address, Toast.LENGTH_SHORT).show();
                if (TextUtils.isEmpty(UserName)) {
                    etName.setError("Enter Username");
                    return;
                }
                if (TextUtils.isEmpty(Age)) {
                    etAge.setError("Enter Age");
                    return;
                }
                if (TextUtils.isEmpty(Address)) {
                    etAddress.setError("Enter Address");
                    return;
                }

                if (rmale.isChecked()) {
                    Gender = "Male";
                }
                if (rfemale.isChecked()) {
                    Gender = "Female";
                }
                if (rothers.isChecked()) {
                    Gender = "Others";
                }

                Student student = new Student(UserName, Address, Gender, Integer.parseInt(Age));
                studentList = student.getStudentList();
                studentList.add(student);
                student.setStudentList(studentList);

                Toast.makeText(getActivity(), "Student Addition Successful: " + UserName, Toast.LENGTH_SHORT).show();

                etName.setText("");
                etAge.setText("");
                etAddress.setText("");
                etAge.setText("");
                rfemale.clearFocus();
                rothers.clearFocus();
                rmale.clearFocus();


                break;
        }
    }
}