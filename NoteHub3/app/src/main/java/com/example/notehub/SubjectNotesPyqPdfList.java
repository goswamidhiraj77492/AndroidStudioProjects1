package com.example.notehub;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SubjectNotesPyqPdfList extends AppCompatActivity {
TextView textView1,textView2,textView3,textView4;
RecyclerView recyclerView;
ArrayList<list_Model> arrayList= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_subject_notes_pyq_pdf_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textView1 = findViewById(R.id.txtsubnpp1);
        textView2 = findViewById(R.id.txtsubnpp2);
        textView3 = findViewById(R.id.txtsubnpp3);
        textView4 = findViewById(R.id.txtsubnpp4);
        String name = getIntent().getStringExtra("name");
        String course = getIntent().getStringExtra("course");
        String subject = getIntent().getStringExtra("subject");
        String type = getIntent().getStringExtra("title");
        textView1.setText("   " + course + " ");
        textView2.setText("   " + name + " ");
        textView3.setText("   " + subject + " ");
        textView4.setText("   " + type + "");


        recyclerView = findViewById(R.id.recyclerviewsubnpp);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if("BCA".equals(course) ){
           if(name.equals("Sem 1") ){
              if (subject.equals("F1001 Business Communication") && type.equals("Notes")) {
                  arrayList.add(new list_Model("F1001 Business Communication Notes"));
              } else if (subject.equals("F1001 Business Communication") && type.equals("PYQ")) {
                  arrayList.add(new list_Model("F1001 Business Communication pyq"));
              } else if (subject.equals("F1002 Basic Mathematics 1") && type.equals("Notes")) {
                  arrayList.add(new list_Model("F1002 Basic Mathematics 1 Notes"));
              } else if ( subject.equals("F1002 Basic Mathematics 1") && type.equals("PYQ")) {
                  arrayList.add(new list_Model("F1002 Basic Mathematics 1 pyq"));
              } else if ( subject.equals("F1003 Business Practices And Management") && type.equals("Notes")) {
                  arrayList.add(new list_Model("F1003 Business Practices And Management Notes"));
              } else if (subject.equals("F1003 Business Practices And Management") && type.equals("PYQ")) {
                  arrayList.add(new list_Model("F1003 Business Practices And Management pyq"));
              } else if ( subject.equals("F1004 Introduction To Computer Science") && type.equals("Notes")) {
                  arrayList.add(new list_Model("F1004 Introduction To Computer Science Notes"));
              } else if ( subject.equals("F1004 Introduction To Computer Science") && type.equals("PYQ")) {
                  arrayList.add(new list_Model("F1004 Introduction To Computer Science pyq"));
              } else if (subject.equals("F1005 Problem solving and Programming in C") && type.equals("Notes")) {
                  arrayList.add(new list_Model("F1005 Problem solving and Programming in C Notes"));
              } else if (subject.equals("F1005 Problem solving and Programming in C") && type.equals("PYQ")) {
                   arrayList.add(new list_Model("F1005 Problem solving and Programming in C pyq"));
              }
            }else if(name.equals("Sem 2") ){
              if (subject.equals("F2001 Basic Mathematics 2") && type.equals("Notes")) {
                  arrayList.add(new list_Model("F2001 Basic Mathematics 2 Notes"));
              } else if (course.equals("BCA") && name.equals("Sem 2") && subject.equals("F2001 Basic Mathematics 2") && type.equals("PYQ")) {
                  arrayList.add(new list_Model("F2001 Basic Mathematics 2 pyq"));
              } else if (subject.equals("F2002 Environmental Science") && type.equals("Notes")) {
                  arrayList.add(new list_Model("F2002 Environmental Science Notes"));
              } else if (subject.equals("F2002 Environmental Science") && type.equals("PYQ")) {
                  arrayList.add(new list_Model("F2002 Environmental Science pyq"));
              } else if ( subject.equals("F2003 Database Management System") && type.equals("Notes")) {
                  arrayList.add(new list_Model("F2003 Database Management System Notes"));
              } else if (subject.equals("F2003 Database Management System") && type.equals("PYQ")) {
                  arrayList.add(new list_Model("F2003 Database Management System pyq"));
              } else if (subject.equals("F2004 Object Oriented Programming using C++") && type.equals("Notes")) {
                  arrayList.add(new list_Model("F2004 Object Oriented Programming using C++ Notes"));
              } else if ( subject.equals("F2004 Object Oriented Programming using C++") && type.equals("PYQ")) {
                  arrayList.add(new list_Model("F2004 Object Oriented Programming using C++ pyq"));
              } else if (subject.equals("F2005 Logic Design") && type.equals("Notes")) {
                  arrayList.add(new list_Model("F2005 Logic Design Notes"));
              } else if (subject.equals("F2005 Logic Design") && type.equals("PYQ")) {
                  arrayList.add(new list_Model("F2005 Logic Design pyq"));
              } else if (subject.equals("F1001 Business Communication") && type.equals("Notes")) {
                  arrayList.add(new list_Model("dhiraj"));
              } else if ( subject.equals("F1001 Business Communication") && type.equals("PYQ")) {
                  arrayList.add(new list_Model("raj"));
              } else if ( subject.equals("F1001 Business Communication") && type.equals("Notes")) {
                  arrayList.add(new list_Model("dhiraj"));
              } else if (subject.equals("F1001 Business Communication") && type.equals("PYQ")) {
                  arrayList.add(new list_Model("raj"));
              }
           }else if(name.equals("Sem 3") ){
             if (subject.equals("C3001 Data Structure using C") && type.equals("Notes")) {
                arrayList.add(new list_Model("C3001 Data Structure using C Notes"));
             } else if (subject.equals("C3001 Data Structure using C") && type.equals("PYQ")) {
                arrayList.add(new list_Model("C3001 Data Structure using C pyq"));
             } else if (subject.equals("F1001 Business Communication") && type.equals("Notes")) {
                 arrayList.add(new list_Model("dhiraj"));
             } else if (subject.equals("F1001 Business Communication") && type.equals("PYQ")) {
                 arrayList.add(new list_Model("raj"));
             } else if (subject.equals("F1001 Business Communication") && type.equals("Notes")) {
                 arrayList.add(new list_Model("dhiraj"));
             } else if (subject.equals("F1001 Business Communication") && type.equals("PYQ")) {
                 arrayList.add(new list_Model("raj"));
             } else if (subject.equals("F1001 Business Communication") && type.equals("Notes")) {
                arrayList.add(new list_Model("dhiraj"));
             } else if ( subject.equals("F1001 Business Communication") && type.equals("PYQ")) {
                arrayList.add(new list_Model("raj"));
             } else if (subject.equals("F1001 Business Communication") && type.equals("Notes")) {
                arrayList.add(new list_Model("dhiraj"));
             } else if (subject.equals("F1001 Business Communication") && type.equals("PYQ")) {
                arrayList.add(new list_Model("raj"));
             } else if ( subject.equals("F1001 Business Communication") && type.equals("Notes")) {
                arrayList.add(new list_Model("dhiraj"));
             } else if ( subject.equals("F1001 Business Communication") && type.equals("PYQ")) {
                arrayList.add(new list_Model("raj"));
             }
            }else if(name.equals("Sem 4") ){
               if (subject.equals("F1001 Business Communication") && type.equals("Notes")) {
                   arrayList.add(new list_Model("dhiraj"));
               } else if ( subject.equals("F1001 Business Communication") && type.equals("PYQ")) {
                   arrayList.add(new list_Model("raj"));
               } else if (subject.equals("F1001 Business Communication") && type.equals("Notes")) {
                   arrayList.add(new list_Model("dhiraj"));
               } else if (subject.equals("F1001 Business Communication") && type.equals("PYQ")) {
                   arrayList.add(new list_Model("raj"));
               } else if (subject.equals("F1001 Business Communication") && type.equals("Notes")) {
                   arrayList.add(new list_Model("dhiraj"));
               } else if (subject.equals("F1001 Business Communication") && type.equals("PYQ")) {
                   arrayList.add(new list_Model("raj"));
               } else if ( subject.equals("F1001 Business Communication") && type.equals("Notes")) {
                   arrayList.add(new list_Model("dhiraj"));
               } else if ( subject.equals("F1001 Business Communication") && type.equals("PYQ")) {
                   arrayList.add(new list_Model("raj"));
               } else if ( subject.equals("F1001 Business Communication") && type.equals("Notes")) {
                   arrayList.add(new list_Model("dhiraj"));
               } else if ( subject.equals("F1001 Business Communication") && type.equals("PYQ")) {
                   arrayList.add(new list_Model("raj"));
               } else if (subject.equals("F1001 Business Communication") && type.equals("Notes")) {
                   arrayList.add(new list_Model("dhiraj"));
               } else if (subject.equals("F1001 Business Communication") && type.equals("PYQ")) {
                   arrayList.add(new list_Model("raj"));
              }
            }else if(name.equals("Sem 5") ){
              if (subject.equals("F1001 Business Communication") && type.equals("Notes")) {
                  arrayList.add(new list_Model("dhiraj"));
              } else if ( subject.equals("F1001 Business Communication") && type.equals("PYQ")) {
                  arrayList.add(new list_Model("raj"));
              } else if (subject.equals("F1001 Business Communication") && type.equals("Notes")) {
                  arrayList.add(new list_Model("dhiraj"));
              } else if (subject.equals("F1001 Business Communication") && type.equals("PYQ")) {
                  arrayList.add(new list_Model("raj"));
              } else if (subject.equals("F1001 Business Communication") && type.equals("Notes")) {
                  arrayList.add(new list_Model("dhiraj"));
              } else if (subject.equals("F1001 Business Communication") && type.equals("PYQ")) {
                  arrayList.add(new list_Model("raj"));
              } else if (subject.equals("F1001 Business Communication") && type.equals("Notes")) {
                  arrayList.add(new list_Model("dhiraj"));
             } else if ( subject.equals("F1001 Business Communication") && type.equals("PYQ")) {
                 arrayList.add(new list_Model("raj"));
            } else if (subject.equals("F1001 Business Communication") && type.equals("Notes")) {
                 arrayList.add(new list_Model("dhiraj"));
            } else if (subject.equals("F1001 Business Communication") && type.equals("PYQ")) {
                  arrayList.add(new list_Model("raj"));
            } else if ( subject.equals("F1001 Business Communication") && type.equals("Notes")) {
                arrayList.add(new list_Model("dhiraj"));
            } else if (subject.equals("F1001 Business Communication") && type.equals("PYQ")) {
                arrayList.add(new list_Model("raj"));
            }
          }else if(name.equals("Sem 1") ){
            if (subject.equals("F1001 Business Communication") && type.equals("Notes")) {
                arrayList.add(new list_Model("dhiraj"));
            } else if (subject.equals("F1001 Business Communication") && type.equals("PYQ")) {
                arrayList.add(new list_Model("raj"));
            } else if (subject.equals("F1001 Business Communication") && type.equals("Notes")) {
                arrayList.add(new list_Model("dhiraj"));
            } else if (subject.equals("F1001 Business Communication") && type.equals("PYQ")) {
                arrayList.add(new list_Model("raj"));
            } else if (subject.equals("F1001 Business Communication") && type.equals("Notes")) {
                arrayList.add(new list_Model("dhiraj"));
            } else if (subject.equals("F1001 Business Communication") && type.equals("PYQ")) {
                arrayList.add(new list_Model("raj"));
            } else if (subject.equals("F1001 Business Communication") && type.equals("Notes")) {
                arrayList.add(new list_Model("dhiraj"));
            } else if (subject.equals("F1001 Business Communication") && type.equals("PYQ")) {
                arrayList.add(new list_Model("raj"));
            } else if (subject.equals("F1001 Business Communication") && type.equals("Notes")) {
                arrayList.add(new list_Model("dhiraj"));
            } else if (subject.equals("F1001 Business Communication") && type.equals("PYQ")) {
                arrayList.add(new list_Model("raj"));
            } else if (subject.equals("F1001 Business Communication") && type.equals("Notes")) {
                arrayList.add(new list_Model("Business Communication Notes"));
            } else if (subject.equals(" Business Communication") && type.equals("PYQ")) {
                arrayList.add(new list_Model("Business Communication pyq"));
            }
         }
        } else if ("BBA".equals(course)) {
            if("Sem 1".equals(name)){

            } else if ("Sem 2".equals(name)) {

            }else if ("Sem 3".equals(name)) {

            }else if ("Sem 4".equals(name)) {

            }else if ("Sem 5".equals(name)) {

            }else if ("Sem 6".equals(name)) {

            }else if ("Sem 7".equals(name)) {

            }else if ("Sem 8".equals(name)) {

            }
        } else if ("B.com".equals(course)) {
            if("Sem 1".equals(name)){

            } else if ("Sem 2".equals(name)) {

            }else if ("Sem 3".equals(name)) {

            }else if ("Sem 4".equals(name)) {

            }else if ("Sem 5".equals(name)) {

            }else if ("Sem 6".equals(name)) {

            }else if ("Sem 7".equals(name)) {

            }else if ("Sem 8".equals(name)) {

            }
        } else if ("Bio.Tech".equals(course)) {
            if("Sem 1".equals(name)){

            } else if ("Sem 2".equals(name)) {

            }else if ("Sem 3".equals(name)) {

            }else if ("Sem 4".equals(name)) {

            }else if ("Sem 5".equals(name)) {

            }else if ("Sem 6".equals(name)) {

            }
        } else if ("Economics".equals(course)) {
            if("Sem 1".equals(name)){

            } else if ("Sem 2".equals(name)) {

            }else if ("Sem 3".equals(name)) {

            }else if ("Sem 4".equals(name)) {

            }else if ("Sem 5".equals(name)) {

            }else if ("Sem 6".equals(name)) {

            }else if ("Sem 7".equals(name)) {

            }else if ("Sem 8".equals(name)) {

            }
        } else if ("English".equals(course)) {
            if("Sem 1".equals(name)){

            } else if ("Sem 2".equals(name)) {

            }else if ("Sem 3".equals(name)) {

            }else if ("Sem 4".equals(name)) {

            }else if ("Sem 5".equals(name)) {

            }else if ("Sem 6".equals(name)) {

            }else if ("Sem 7".equals(name)) {

            }else if ("Sem 8".equals(name)) {

            }
        } else if ("Math".equals(course)) {
            if("Sem 1".equals(name)){

            } else if ("Sem 2".equals(name)) {

            }else if ("Sem 3".equals(name)) {

            }else if ("Sem 4".equals(name)) {

            }else if ("Sem 5".equals(name)) {

            }else if ("Sem 6".equals(name)) {

            }else if ("Sem 7".equals(name)) {

            }else if ("Sem 8".equals(name)) {

            }
        } else if ("Physics".equals(course)) {
            if("Sem 1".equals(name)){

            } else if ("Sem 2".equals(name)) {

            }else if ("Sem 3".equals(name)) {

            }else if ("Sem 4".equals(name)) {

            }else if ("Sem 5".equals(name)) {

            }else if ("Sem 6".equals(name)) {

            }else if ("Sem 7".equals(name)) {

            }else if ("Sem 8".equals(name)) {

            }
        } else if ("Chemistry".equals(course)) {
            if("Sem 1".equals(name)){

            } else if ("Sem 2".equals(name)) {

            }else if ("Sem 3".equals(name)) {

            }else if ("Sem 4".equals(name)) {

            }else if ("Sem 5".equals(name)) {

            }else if ("Sem 6".equals(name)) {

            }else if ("Sem 7".equals(name)) {

            }else if ("Sem 8".equals(name)) {

            }
        } else if ("History".equals(course)) {
            if("Sem 1".equals(name)){

            } else if ("Sem 2".equals(name)) {

            }else if ("Sem 3".equals(name)) {

            }else if ("Sem 4".equals(name)) {

            }else if ("Sem 5".equals(name)) {

            }else if ("Sem 6".equals(name)) {

            }else if ("Sem 7".equals(name)) {

            }else if ("Sem 8".equals(name)) {

            }
        } else if ("Geography".equals(course)) {
            if("Sem 1".equals(name)){

            } else if ("Sem 2".equals(name)) {

            }else if ("Sem 3".equals(name)) {

            }else if ("Sem 4".equals(name)) {

            }else if ("Sem 5".equals(name)) {

            }else if ("Sem 6".equals(name)) {

            }else if ("Sem 7".equals(name)) {

            }else if ("Sem 8".equals(name)) {

            }
        }

        SubjectListRecyclerAdapter adapter = new SubjectListRecyclerAdapter(this,arrayList,course,name,subject,type);
        recyclerView.setAdapter(adapter);
    }
}