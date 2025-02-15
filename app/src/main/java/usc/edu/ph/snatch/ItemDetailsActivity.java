package usc.edu.ph.snatch;

import android.content.Intent;
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

public class ItemDetailsActivity extends AppCompatActivity {

    TextView itemName, itemPrice, quantity;

    Button checkoutBtn, incrementBtn, decrementBtn;

    ImageView image;

    int defaultQuantity = 1;
    int maxQuantity = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_item_details);

        itemName = findViewById(R.id.name);
        itemPrice = findViewById(R.id.price);
        quantity = findViewById(R.id.quantity);
        image = findViewById(R.id.foodImage);

        checkoutBtn = findViewById(R.id.checkout);
        incrementBtn = findViewById(R.id.increment);
        decrementBtn = findViewById(R.id.decrement);


        itemName.setText(getIntent().getStringExtra("name"));
        // Get and set price
        int price = getIntent().getIntExtra("price", 0);
        itemPrice.setText(String.valueOf(price));

        // Set image
        int imgId = getIntent().getIntExtra("image", 0);
        if (imgId != 0) {
            image.setImageResource(imgId);
        }

        quantity.setText(String.valueOf(defaultQuantity));

        incrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(defaultQuantity < maxQuantity){
                    defaultQuantity++;

                    quantity.setText(String.valueOf(defaultQuantity));

                }
            }
        });

        decrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(defaultQuantity > 1){
                    defaultQuantity--;

                    quantity.setText(String.valueOf(defaultQuantity));
                }
            }
        });

        checkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = itemName.getText().toString();
                int price = Integer.parseInt(itemPrice.getText().toString());
                NewHomeActivity.addToCart(name, price, defaultQuantity);

                finish();
            }
        });
    }
}