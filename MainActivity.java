package constantrebel.com.athar.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
Button btnActivity1;
Button btnActivity2;
Button btnActivity3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnActivity1=(Button) findViewById(R.id.btn1);
        btnActivity2=(Button) findViewById(R.id.btn2);
        btnActivity3=(Button) findViewById(R.id.btn3);

    }
    public void btnClickAct1(View v){
        Intent i =new Intent(this,CallActivity.class);
        startActivity(i);
    }
    public void btnClickAct2(View v){
        Intent i =new Intent(this, MessageActivity.class);
        startActivity(i);
    }
    public void btnClickAct3(View v){
        Intent i =new Intent(this, ContactActivity.class);
        startActivity(i);
    }
}
