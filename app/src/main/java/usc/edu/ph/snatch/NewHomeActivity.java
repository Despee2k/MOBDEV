package usc.edu.ph.snatch;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class NewHomeActivity extends AppCompatActivity {

    ListView myListView;
    Spinner mySpinner;
    Button logout, checkout;
    TextView username;

    ArrayAdapter<PizzaOptions> adapter;
    String[] categories = {"All", "Classic", "International"};

    private static ArrayList<OrderItem> cartItems = new ArrayList<>();
    private static int cartTotal = 0;

    private static final Object[][] PIZZA_DATA = {
            {"Pepperoni", 1, 300, R.drawable.pepperoni_pizza},
            {"Cheese", 1, 275, R.drawable.cheese_pizza},
            {"Greek", 2, 300, R.drawable.meat_pizza},
            {"Chicago-style", 2, 325, R.drawable.bbq_pizza}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new_home2);

        initializeViews();
    }

    @SuppressLint("SetTextI18n")
    private void initializeViews() {
        mySpinner = findViewById(R.id.mySpinner);
        mySpinner.setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categories)
        );

        myListView = findViewById(R.id.myListView);
        adapter = new MyListAdapter(this, getPizzaOptions());
        myListView.setAdapter(adapter);

        // Get username from intent (if available)
        username = findViewById(R.id.username);
        String user = getIntent().getStringExtra("username");
        if (user != null) {
            username.setText("Hello, " + user);
        }

        // Initialize logout & checkout buttons
        logout = findViewById(R.id.logoutBtn);
        checkout = findViewById(R.id.checkout);

        logout.setOnClickListener(v -> {
            Intent logoutIntent = new Intent(NewHomeActivity.this, LoginActivity.class);
            startActivity(logoutIntent);
            finish();
        });

        checkout.setOnClickListener(v -> {
            Intent intentCheckout = new Intent(NewHomeActivity.this, CheckoutActivity.class);
            intentCheckout.putStringArrayListExtra("items", getCartItemsFormatted());
            intentCheckout.putExtra("total", cartTotal);
            startActivity(intentCheckout);
        });

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position >= 0 && position < categories.length) {
                    getSelectedCategoryData(position);
                } else {
                    Toast.makeText(NewHomeActivity.this, "Does not exist!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    private ArrayList<PizzaOptions> getPizzaOptions() {
        ArrayList<PizzaOptions> data = new ArrayList<>();
        for (Object[] pizza : PIZZA_DATA) {
            data.add(new PizzaOptions(
                    (String) pizza[0],  // Name
                    (int) pizza[1],     // Category ID
                    (int) pizza[2],     // Price
                    (int) pizza[3]      // Image ID
            ));
        }
        return data;
    }

    private void getSelectedCategoryData(int categoryID) {
        List<PizzaOptions> pizzaOptions = new ArrayList<>();

        if (categoryID == 0) {
            pizzaOptions = getPizzaOptions();
        } else {
            for (PizzaOptions pizzaOption : getPizzaOptions()) {
                if (pizzaOption.getCategoryID() == categoryID) {
                    pizzaOptions.add(pizzaOption);
                }
            }
        }

        adapter = new MyListAdapter(this, pizzaOptions);
        myListView.setAdapter(adapter);
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
        checkout.setText("Checkout (₱" + cartTotal + ")");
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateCheckoutButton();
    }

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
}
