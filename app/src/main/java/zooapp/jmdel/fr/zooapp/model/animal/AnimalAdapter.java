package zooapp.jmdel.fr.zooapp.model.animal;

import android.content.Context;
import android.widget.TextView;

import java.util.ArrayList;

import zooapp.jmdel.fr.zooapp.model.GenericArrayAdapter;
import zooapp.jmdel.fr.zooapp.model.animal.Animal;

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