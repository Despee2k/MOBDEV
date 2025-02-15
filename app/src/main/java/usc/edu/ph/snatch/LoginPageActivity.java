package usc.edu.ph.snatch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginPageActivity extends AppCompatActivity {

    Button loginButton;

    EditText editUsername, editPassword;

    TextView wrongContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_page);

        // Buttons
        loginButton = findViewById(R.id.loginBtn);

        // Edit Fields
        editUsername = findViewById(R.id.editUser);
        editPassword = findViewById(R.id.editPass);

        // Text Fields
        wrongContent = findViewById(R.id.wrongLoginInfo);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameFieldContent = editUsername.getText().toString();
                String passwordFieldContent = editPassword.getText().toString();
                if(usernameFieldContent.equals("Reynat Gwapo") && passwordFieldContent.equals("true")){
                    Intent intentLogin = new Intent(LoginPageActivity.this, NewHomeActivity.class);
                    intentLogin.putExtra("username", usernameFieldContent);

                    startActivity(intentLogin);
                } else {
                    wrongContent.setText("WRONG USERNAME OR PASSWORD");
                }
            }
        });
    }
}