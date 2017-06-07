package constantrebel.com.athar.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MessageCompose extends AppCompatActivity {
    Button button;
    EditText editText, editText2;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        if (ContextCompat.checkSelfPermission(MessageCompose.this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(MessageCompose.this,
                    Manifest.permission.SEND_SMS)) {
                ActivityCompat.requestPermissions(MessageCompose.this,
                        new String[]{Manifest.permission.SEND_SMS}, 1);
            } else {
                ActivityCompat.requestPermissions(MessageCompose.this,
                        new String[]{Manifest.permission.SEND_SMS}, 1);
            }
        }else {
            //do nothing
        }

        button = (Button) findViewById(R.id.button);
        editText=(EditText) findViewById(R.id.editText);
        editText2=(EditText) findViewById(R.id.editText2);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                String number=editText.getText().toString();
                String sms=editText2.getText().toString();
                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(number,null,sms,null,null);
                    Toast.makeText(MessageCompose.this, "Sent!", Toast.LENGTH_SHORT).show();

                }
                catch (Exception e){
                    Toast.makeText(MessageCompose.this,"Failed!",Toast.LENGTH_SHORT).show();
                }

            }
        });
        }
    @Override
    public void onRequestPermissionsResult(int requestCode ,  String[] permissions,  int[]
            grantResults){
       switch (requestCode){
           case 1:{
               if (grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                   if (ContextCompat.checkSelfPermission(MessageCompose.this,Manifest.permission.SEND_SMS)
                           ==PackageManager.PERMISSION_GRANTED){
                       Toast.makeText(this,"Permission Granted",Toast.LENGTH_SHORT).show();
                   }
               } else {
                   Toast.makeText(this,"No permission granted!" ,Toast.LENGTH_SHORT).show();
               }
               return;
           }
       }
    }
    }