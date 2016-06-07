package zooapp.jmdel.fr.zooapp.model;

import android.content.Context;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hb on 07/06/2016.
 */
public class EnclosAdapter extends GenericArrayAdapter<Enclos> {

    public EnclosAdapter(Context context, ArrayList<Enclos> objects)  {
        super(context, objects);
    }

    @Override
    public void drawText(TextView textView, Enclos object) {
        textView.setText(object.getId()
                + " - " + object.getNom()
                + " - " + object.getNbAnimal()
                + " - " + object.getNbAnimalMax());
    }
}
