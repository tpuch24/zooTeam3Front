package zooapp.jmdel.fr.zooapp.model.Food;

import android.content.Context;
import android.widget.TextView;

import java.util.ArrayList;

import zooapp.jmdel.fr.zooapp.model.Food.Food;
import zooapp.jmdel.fr.zooapp.model.GenericArrayAdapter;

/**
 * Created by jean-michel on 07/06/2016.
 */
public class FoodAdapter extends GenericArrayAdapter<Food> {
    public FoodAdapter(Context context, ArrayList<Food> objects) {
        super(context, objects);
    }

    @Override
    public void drawText(TextView textView, Food object) {
        String listItemLine = object.getName()+" : "+ object.getStock().toString()+" "+ object.getUnity();
        textView.setText(listItemLine);

    }


}
