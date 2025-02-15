package usc.edu.ph.snatch;

import android.app.ComponentCaller;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    ImageView profilePICTURE;
    Button saveBUTTON, nextBUTTON, browseBUTTON;

    TextView Name, Course, Year, Wham;

    EditText edName, edCourse, edYear, edWham;

    int reqCode = 101;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.name);
        Course = findViewById(R.id.course);
        Year = findViewById(R.id.year);
        Wham = findViewById(R.id.wham);


        profilePICTURE = (ImageView) findViewById(R.id.profilepicture);
        profilePICTURE.setImageResource(R.drawable.placeholder);

        saveBUTTON = findViewById(R.id.button);
        nextBUTTON = findViewById(R.id.nextBtn);
        browseBUTTON = findViewById(R.id.browseBtn);

        edName = findViewById(R.id.edname);
        edCourse = findViewById(R.id.edcourse);
        edYear = findViewById(R.id.edyear);
        edWham = findViewById(R.id.edwham);

        saveBUTTON.setOnClickListener(new View.OnClickListener() {
            boolean show = false;

            @Override
            public void onClick(View view) {
                String setName = edName.getText().toString();
                String setCourse = edCourse.getText().toString();
                String setYear = edYear.getText().toString();
                String setWham = edWham.getText().toString();

                show = !show;

                if(show){
                    Name.setText(setName);
                    Course.setText(setCourse);
                    Year.setText(setYear);
                    Wham.setText(setWham);
                } else {
                    Name.setText("");
                    Course.setText("");
                    Year.setText("");
                    Wham.setText("");
                }
            }
        });

        nextBUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtName = Name.getText().toString();
                String txtCourse = Course.getText().toString();
                String txtYear = Year.getText().toString();
                String txtWham = Wham.getText().toString();


                Intent intentCounter = new Intent(MainActivity.this, CounterActivity.class);
                intentCounter.putExtra("name", txtName);
                intentCounter.putExtra("course", txtCourse);
                intentCounter.putExtra("year", txtYear);
                intentCounter.putExtra("wham", txtWham);
                intentCounter.setData(uri);

                startActivity(intentCounter);
            }
        });

        browseBUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBrowse = new Intent(Intent.ACTION_GET_CONTENT);
                intentBrowse.setType("image/*");
                //noinspection deprecation
                startActivityForResult(Intent.createChooser(intentBrowse, "Select Image"), reqCode);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data, @NonNull ComponentCaller caller) {
        super.onActivityResult(requestCode, resultCode, data, caller);

        if(requestCode == reqCode & null != data){
            uri = data.getData();
            profilePICTURE.setImageURI(uri);
        } else {
            profilePICTURE.setImageResource(R.drawable.placeholder);
        }
    }
}