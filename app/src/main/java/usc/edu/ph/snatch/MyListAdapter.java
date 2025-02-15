package usc.edu.ph.snatch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MyListAdapter extends ArrayAdapter<PizzaOptions> {

    private final Activity context;
    private final List<PizzaOptions> pizzaList;

    public MyListAdapter(Activity context, List<PizzaOptions> pizzaList) {
        super(context, R.layout.pizza_layout, pizzaList);
        this.context = context;
        this.pizzaList = pizzaList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.pizza_layout, null, true);

        ImageView img = rowView.findViewById(R.id.pizzaImg);
        TextView name = rowView.findViewById(R.id.pizzaName);
        TextView price = rowView.findViewById(R.id.pizzaPrice);
        Button button = rowView.findViewById(R.id.foodBtn);

        PizzaOptions pizza = pizzaList.get(position);

        if (img != null) {
            img.setImageResource(pizza.getImageID());  // Set pizza image
        }

        name.setText(pizza.getName());
        price.setText("₱" + pizza.getPrice()); // Format price with currency

        // ✅ Open ItemDetailsActivity when clicking the button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOrder = new Intent(context, ItemDetailsActivity.class);
                intentOrder.putExtra("name", pizza.getName());
                intentOrder.putExtra("price", pizza.getPrice());
                intentOrder.putExtra("image", pizza.getImageID());

                context.startActivity(intentOrder);
            }
        });

        return rowView;
    }
}
