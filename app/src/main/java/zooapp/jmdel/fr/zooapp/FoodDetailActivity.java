package zooapp.jmdel.fr.zooapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FoodDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        Bundle extra = getIntent().getExtras();
        String food_name = extra.getString("s_food_name");

        ((TextView)(findViewById(R.id.food_detail_name))).setText(food_name);
    }

}
