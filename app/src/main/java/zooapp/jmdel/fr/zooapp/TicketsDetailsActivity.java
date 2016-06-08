package zooapp.jmdel.fr.zooapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TicketsDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets_details);

        Intent intent = getIntent();
        String str = intent.getStringExtra("reference");

        final TextView txtv = (TextView)findViewById(R.id.textView4);

        assert txtv != null;
        txtv.setText(str);

        FloatingActionButton ticket = (FloatingActionButton) findViewById(R.id.ticketUpdate);
        assert ticket != null;
        ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TicketsDetailsActivity.this,TicketsUpdateActivity.class);
                startActivity(intent);
            }
        });

    }
}
