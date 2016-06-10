package zooapp.jmdel.fr.zooapp.ticket.model;

import android.content.Context;
import android.widget.TextView;

import java.util.ArrayList;

import zooapp.jmdel.fr.zooapp.model.GenericArrayAdapter;

/**
 * Created by Thierry on 06/06/2016.
 */
public class TicketAdapter extends GenericArrayAdapter<Ticket> {

    public TicketAdapter(Context context, ArrayList<Ticket> objects) {
        super(context, objects);
    }

    @Override public void drawText(TextView textView, Ticket object) {
        textView.setText(object.getDate()+" - "+ object.getCategory());
    }

}