package usc.edu.ph.snatch;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CounterActivity extends AppCompatActivity {

    Button Increment, Decrement, backBUTTON;
    TextView Value;
    TextView Name, Course, Year, Wham;
    ImageView ProfilePicture;
    int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        Increment = findViewById(R.id.increment);
        Decrement = findViewById(R.id.decrement);
        Value = findViewById(R.id.value);
        backBUTTON = findViewById(R.id.backBtn);

        Name = findViewById(R.id.name);
        Course = findViewById(R.id.course);
        Year = findViewById(R.id.year);
        Wham = findViewById(R.id.wham);

        ProfilePicture = findViewById(R.id.pfp);
        ProfilePicture.setImageURI(getIntent().getData());

        Name.setText(getIntent().getStringExtra("name"));
        Course.setText(getIntent().getStringExtra("course"));
        Year.setText(getIntent().getStringExtra("year"));
        Wham.setText(getIntent().getStringExtra("wham"));

        backBUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMain = new Intent(CounterActivity.this, MainActivity.class);
                startActivity(intentMain);
            }
        });

        Increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number++;
                Value.setText(String.valueOf(number));
            }
        });

        Decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(number > 0){
                    number--;
                    Value.setText(String.valueOf(number));
                }
            }
        });
    }
}