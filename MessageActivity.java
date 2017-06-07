package constantrebel.com.athar.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MessageActivity extends AppCompatActivity {

    Button btnActivity1;
    Button btnActivity2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        btnActivity1=(Button) findViewById(R.id.button2);
        btnActivity2=(Button) findViewById(R.id.button1);
    }
    public  void btnClickAct1 (View v){

        Intent i=new Intent(this,MessageCompose.class);
        startActivity(i);
    }
    public void btnClickAct2 (View v) {
        Intent i =new Intent(this,MessageConversation.class);
        startActivity(i);
    }

}
