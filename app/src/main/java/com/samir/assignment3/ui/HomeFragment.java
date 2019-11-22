package com.samir.assignment3.ui;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.samir.assignment3.R;
import com.samir.assignment3.Student.Student;
import com.samir.assignment3.adapter.StudentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    //to display the list item of the student in recyclerView

    static List<Student> studentList = new ArrayList<>();

    private RecyclerView recycler_view;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recycler_view = root.findViewById(R.id.recycler_view);

        //Add the contact

        Student student = new Student("Samir", "ktm","Male",23);
        studentList = student.getStudentList();

        if (studentList.isEmpty()){
            studentList.add(new Student("Samir","ktm","Male",22));

            student.setStudentList(studentList);

        }
        StudentAdapter studentAdapter = new StudentAdapter(getActivity(),studentList);

        recycler_view.setAdapter(studentAdapter);
        recycler_view.setLayoutManager(new LinearLayoutManager(getActivity()));

        return root;
    }
}
