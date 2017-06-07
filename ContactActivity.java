package constantrebel.com.athar.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {

    private Button loadContacts ;
    private TextView listContacts;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        listContacts = (TextView) findViewById(R.id.listContacts);
        loadContacts = (Button)     findViewById(R.id.loadContacts);
        loadContacts.setOnClickListener(new onClickListener(){
         @Override
            public void onClick (View v) {
             loadContacts()
         }

        });

    }
}
