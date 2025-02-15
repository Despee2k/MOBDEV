package usc.edu.ph.snatch;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.List;

public class SpinnerListActivity extends AppCompatActivity {

    Spinner listSpin;
    ListView list;

    Integer[] imgId = {
            R.drawable.bbq_pizza,
            R.drawable.cheese_pizza,
            R.drawable.hawaiian_pizza,
            R.drawable.meat_pizza
    };

    String[] courses = {
            "Android",
            "Java",
            "Python",
            "C programming"
    };

    String[] topics = {
            "Algorithms and Complexity",
            "Philnits",
            "OOP",
            "Gacha Games",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spinner_list);
//
//        listSpin = findViewById(R.id.listSpin);
//        listSpin.setOnItemSelectedListener(this);
//        list = findViewById(R.id.list);
//
//        MyListAdapter adapter = new MyListAdapter(this, );
//        list.setAdapter(adapter);
//
//        ArrayAdapter<String> arrCourses = new ArrayAdapter<>(
//                this,
//                android.R.layout.simple_spinner_item, courses
//        );
//        listSpin.setAdapter(arrCourses);
//
////        ArrayAdapter<String> arrTopics = new ArrayAdapter<>(
////                this,
////                android.R.layout.simple_spinner_item, topics
////        );
////        list.setAdapter(arrTopics);
//    }
//
//    @Override
//    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        Toast.makeText(getApplicationContext(), courses[i], Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//
    }
}