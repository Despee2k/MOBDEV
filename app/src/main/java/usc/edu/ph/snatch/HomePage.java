package usc.edu.ph.snatch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {

    private static class OrderItem {
        String name;
        int price;
        int quantity;

        OrderItem(String name, int price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }
    }

    private static ArrayList<OrderItem> cartItems = new ArrayList<>();
    private static int cartTotal = 0;
    Button order1, order2, order3, order4, order5, order6;

    Button logout, checkout;

    TextView username;
    TextView foodName1, foodName2, foodName3, foodName4, foodName5, foodName6;

    TextView foodPrice1, foodPrice2, foodPrice3, foodPrice4, foodPrice5, foodPrice6;

    int img1 = R.drawable.pepperoni_pizza;
    int img2 = R.drawable.supreme_pizza;
    int img3 = R.drawable.cheese_pizza;
    int img4 = R.drawable.hawaiian_pizza;

    int img5 = R.drawable.bbq_pizza;
    int img6 = R.drawable.meat_pizza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);

        // Buttons
        order1 = findViewById(R.id.food1);
        order2 = findViewById(R.id.food2);
        order3 = findViewById(R.id.food3);
        order4 = findViewById(R.id.food4);
        order5 = findViewById(R.id.food5);
        order6 = findViewById(R.id.food6);

        foodName1 = findViewById(R.id.foodName1);
        foodName2 = findViewById(R.id.foodName2);
        foodName3 = findViewById(R.id.foodName3);
        foodName4 = findViewById(R.id.foodName4);
        foodName5 = findViewById(R.id.foodName5);
        foodName6 = findViewById(R.id.foodName6);

        foodPrice1 = findViewById(R.id.foodPrice1);
        foodPrice2 = findViewById(R.id.foodPrice2);
        foodPrice3 = findViewById(R.id.foodPrice3);
        foodPrice4 = findViewById(R.id.foodPrice4);
        foodPrice5 = findViewById(R.id.foodPrice5);
        foodPrice6 = findViewById(R.id.foodPrice6);

        username = findViewById(R.id.username);
        username.setText(getIntent().getStringExtra("username"));

        logout = findViewById(R.id.logoutBtn);
        checkout = findViewById(R.id.checkout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logoutIntent = new Intent(HomePage.this, LoginActivity.class);

                startActivity(logoutIntent);
            }
        });

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCheckout = new Intent(HomePage.this, CheckoutActivity.class);
                intentCheckout.putStringArrayListExtra("items", getCartItemsFormatted());
                intentCheckout.putExtra("total", cartTotal);
                startActivity(intentCheckout);
            }
        });

        order1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameOfProduct = foodName1.getText().toString();
                String priceOfProduct = foodPrice1.getText().toString();

                Intent intentOrder = new Intent(HomePage.this, ItemDetailsActivity.class);

                intentOrder.putExtra("name", nameOfProduct);
                intentOrder.putExtra("price", priceOfProduct);
                intentOrder.putExtra("image", img1);

                startActivity(intentOrder);
            }
        });

        order2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameOfProduct = foodName2.getText().toString();
                String priceOfProduct = foodPrice2.getText().toString();

                Intent intentOrder = new Intent(HomePage.this, ItemDetailsActivity.class);

                intentOrder.putExtra("name", nameOfProduct);
                intentOrder.putExtra("price", priceOfProduct);
                intentOrder.putExtra("image", img2);

                startActivity(intentOrder);
            }
        });

        order3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameOfProduct = foodName3.getText().toString();
                String priceOfProduct = foodPrice3.getText().toString();

                Intent intentOrder = new Intent(HomePage.this, ItemDetailsActivity.class);

                intentOrder.putExtra("name", nameOfProduct);
                intentOrder.putExtra("price", priceOfProduct);
                intentOrder.putExtra("image", img3);

                startActivity(intentOrder);
            }
        });

        order4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameOfProduct = foodName4.getText().toString();
                String priceOfProduct = foodPrice4.getText().toString();

                Intent intentOrder = new Intent(HomePage.this, ItemDetailsActivity.class);

                intentOrder.putExtra("name", nameOfProduct);
                intentOrder.putExtra("price", priceOfProduct);
                intentOrder.putExtra("image", img4);

                startActivity(intentOrder);
            }
        });

        order5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameOfProduct = foodName5.getText().toString();
                String priceOfProduct = foodPrice5.getText().toString();

                Intent intentOrder = new Intent(HomePage.this, ItemDetailsActivity.class);

                intentOrder.putExtra("name", nameOfProduct);
                intentOrder.putExtra("price", priceOfProduct);
                intentOrder.putExtra("image", img5);

                startActivity(intentOrder);
            }
        });

        order6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameOfProduct = foodName6.getText().toString();
                String priceOfProduct = foodPrice6.getText().toString();

                Intent intentOrder = new Intent(HomePage.this, ItemDetailsActivity.class);

                intentOrder.putExtra("name", nameOfProduct);
                intentOrder.putExtra("price", priceOfProduct);
                intentOrder.putExtra("image", img6);

                startActivity(intentOrder);
            }
        });
    }
    public static void addToCart(String name, int price, int quantity) {
        boolean itemExists = false;
        for (OrderItem item : cartItems) {
            if (item.name.equals(name)) {
                item.quantity += quantity;
                itemExists = true;
                break;
            }
        }
        if (!itemExists) {
            cartItems.add(new OrderItem(name, price, quantity));
        }
        cartTotal += price * quantity;
    }
    private ArrayList<String> getCartItemsFormatted() {
        ArrayList<String> formattedItems = new ArrayList<>();
        for (OrderItem item : cartItems) {
            formattedItems.add(item.name + " x" + item.quantity + " = ₱" + (item.price * item.quantity));
        }
        return formattedItems;
    }

    private void updateCheckoutButton() {
        checkout.setText("Checkout (P" + cartTotal + ")");
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateCheckoutButton();
    }
}