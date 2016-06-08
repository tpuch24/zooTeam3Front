package zooapp.jmdel.fr.zooapp.enclos.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import zooapp.jmdel.fr.zooapp.model.GenericArrayAdapter;

/**
 * Created by hb on 08/06/2016.
 */
public class TypeEnclosAdapter extends GenericArrayAdapter<String> {

    public TypeEnclosAdapter(Context context, ArrayList<String> objects)  {
        super(context, objects);
    }

    public void drawText(TextView textView, String typeEnclos) {
        textView.setText(typeEnclos);
    }

}
