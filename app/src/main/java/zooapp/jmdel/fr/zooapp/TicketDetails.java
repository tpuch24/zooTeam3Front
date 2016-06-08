package zooapp.jmdel.fr.zooapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TicketDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_details);

        Intent intent = getIntent();
        String str = intent.getStringExtra("reference");

        final TextView txtv = (TextView)findViewById(R.id.textView4);

        assert txtv != null;
        txtv.setText(str);
    }
}
