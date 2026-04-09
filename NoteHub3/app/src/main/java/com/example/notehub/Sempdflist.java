package com.example.notehub;

import android.content.Intent;
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




public class Sempdflist extends AppCompatActivity {
    public static Void getAdd(ArrayList<list_Model> arrayList,String sub1,String sub2,String sub3, String sub4, String sub5) {
        arrayList.add(new list_Model(sub1));
        arrayList.add(new list_Model(sub2));
        arrayList.add(new list_Model(sub3));
        arrayList.add(new list_Model(sub4));
        arrayList.add(new list_Model(sub5));
      return null;}

    public static Void getAdd(ArrayList<list_Model> arrayList,String sub1,String sub2,String sub3, String sub4) {
        arrayList.add(new list_Model(sub1));
        arrayList.add(new list_Model(sub2));
        arrayList.add(new list_Model(sub3));
        arrayList.add(new list_Model(sub4));
        return null;}

    RecyclerView recyclerView;
    ArrayList<list_Model> arrayList = new ArrayList<list_Model>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sem_pdf_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.semSubRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        String name = getIntent().getStringExtra("title");
        String course = getIntent().getStringExtra("key");

        if("BCA".equals(course)) {
            if ("Sem 1".equals(name)) {
                getAdd(arrayList, "F1001 Business Communication", "F1002 Basic Mathematics 1",
                        "F1003 Business Practices And Management", "F1004 Introduction To Computer Science",
                        "F1005 Problem solving and Programming in C");
            } else if ("Sem 2".equals(name)) {
                getAdd(arrayList, "F2001 Basic Mathematics 2", "F2002 Environmental Science",
                        "F2003 Database Management System", "F2004 Object Oriented Programming using C++",
                        "F2005 Logic Design");
            } else if ("Sem 3".equals(name)) {
                getAdd(arrayList, "C3001 Data Structure using C", "C3002 Java Programming",
                        "C3003 Computer Architecture", "C3004 System Analysis and Design",
                        "C3005 Probability and Statistics");
            } else if ("Sem 4".equals(name)) {
                getAdd(arrayList, "C4001 Multimedia", "C4002 Operating System", "C4003 HTML",
                        "C4004 Visual Programming", "C4005 Computer Networks");
            } else if ("Sem 5".equals(name)) {
                getAdd(arrayList, "C5001 Internet Concept and Web Design", "C5002 Design and Analysis of Algorithms",
                        "C5003 Linux Programming ", "C5004 Computer Oriented Numerical Methods", "Elective-1");
            } else if ("Sem 6".equals(name)) {
                getAdd(arrayList, "C6001 Optimization Techniques", "C6002 Principal of Management",
                        "C6003 Accounting and Financial Management", "C6004 Network Security", "Elective-2");
            }
        }
//        }else if("BBA".equals(course)) {
//            if ( "Sem 1".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 2".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 3".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 4".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 5".equals(name)) {
//                getAdd(arrayList, );
//            } else if ("Sem 6".equals(name)) {
//                getAdd(arrayList,);
//            }
//
//        }else if("B.com".equals(course)) {
//            if ( "Sem 1".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 2".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 3".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 4".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 5".equals(name)) {
//                getAdd(arrayList, );
//            } else if ("Sem 6".equals(name)) {
//                getAdd(arrayList,);
//            }
//        }else if("Bio.tech".equals(course)) {
//
//            if ( "Sem 1".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 2".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 3".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 4".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 5".equals(name)) {
//                getAdd(arrayList, );
//            } else if ("Sem 6".equals(name)) {
//                getAdd(arrayList,);
//            }
//        }else if("Economics".equals(course)) {
//            if ( "Sem 1".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 2".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 3".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 4".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 5".equals(name)) {
//                getAdd(arrayList, );
//            } else if ("Sem 6".equals(name)) {
//                getAdd(arrayList,);
//            }
//
//        }else if("English".equals(course)) {
//            if ( "Sem 1".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 2".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 3".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 4".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 5".equals(name)) {
//                getAdd(arrayList, );
//            } else if ("Sem 6".equals(name)) {
//                getAdd(arrayList,);
//            }
//
//        }else if("Math".equals(course)) {
//            if ( "Sem 1".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 2".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 3".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 4".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 5".equals(name)) {
//                getAdd(arrayList, );
//            } else if ("Sem 6".equals(name)) {
//                getAdd(arrayList,);
//            }
//
//        }else if("Physics".equals(course)) {
//            if ( "Sem 1".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 2".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 3".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 4".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 5".equals(name)) {
//                getAdd(arrayList, );
//            } else if ("Sem 6".equals(name)) {
//                getAdd(arrayList,);
//            }
//
//        }else if("Chemistry".equals(course)) {
//            if ( "Sem 1".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 2".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 3".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 4".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 5".equals(name)) {
//                getAdd(arrayList, );
//            } else if ("Sem 6".equals(name)) {
//                getAdd(arrayList,);
//            }
//
//        }else if("History".equals(course)) {
//            if ( "Sem 1".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 2".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 3".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 4".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 5".equals(name)) {
//                getAdd(arrayList, );
//            } else if ("Sem 6".equals(name)) {
//                getAdd(arrayList,);
//            }
//
//        }else if("Geography".equals(course)) {
//            if ( "Sem 1".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 2".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 3".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 4".equals(name)) {
//                getAdd(arrayList, );
//            } else if ( "Sem 5".equals(name)) {
//                getAdd(arrayList, );
//            } else if ("Sem 6".equals(name)) {
//                getAdd(arrayList,);
//            }
//        }

    RecyclerSublistAdapter adapter = new RecyclerSublistAdapter(this, arrayList, name, course);
        recyclerView.setAdapter(adapter);
    }
}

