package zooapp.jmdel.fr.zooapp.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Thierry on 06/06/2016.
 */
public class AnimalAdapter extends GenericArrayAdapter<Animal> {

    public AnimalAdapter(Context context, ArrayList<Animal> objects) {
        super(context, objects);
    }

    @Override public void drawText(TextView textView, Animal object) {
        textView.setText(object.getName()+" - "+ object.getSpecy());
    }

}