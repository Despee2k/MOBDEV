package usc.edu.ph.snatch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class CheckoutActivity extends AppCompatActivity {
    Button homeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        TextView orderSummary = findViewById(R.id.orderSummary);
        TextView totalAmount = findViewById(R.id.totalAmount);

        ArrayList<String> items = getIntent().getStringArrayListExtra("items");
        int total = getIntent().getIntExtra("total", 0);

        StringBuilder summary = new StringBuilder();
        for (String item : items) {
            summary.append(item).append("\n");
        }

        orderSummary.setText(summary.toString());
        totalAmount.setText("Total Amount: ₱" + total);
    }
}