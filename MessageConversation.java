package constantrebel.com.athar.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;
import android.database.Cursor;
import android.content.pm.PackageManager;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;

public class MessageConversation extends AppCompatActivity {

    ListView listView;
    private static final int PERMISSION_REQUEST_READ_CONTACTS=100;
    ArrayList smsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        listView =(ListView) findViewById(R.id.idList);

        //Method to Start the Service
        int permissionCheck = ContextCompat.checkSelfPermission(this,Manifest.permission.READ_SMS);
        if (permissionCheck == PackageManager.PERMISSION_GRANTED){
            //Name for Method For Calling Message
            showContacts();

        }else{
            //TODO
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_SMS}, PERMISSION_REQUEST_READ_CONTACTS);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,  String[] permissions, int[] grantResults) {
      if (requestCode==PERMISSION_REQUEST_READ_CONTACTS){
          if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
              //Permission is Granted
              showContacts();
          }else{
              Toast.makeText(this,"Until ",Toast.LENGTH_SHORT).show();
          }
      }
    }
    private void showContacts(){
        //Create inbox box uri
      Uri inboxUri= Uri.parse("content://sms/inbox");
        smsList=new ArrayList();
        //Get Content Resolver object ,which will deal with Content Provider
        ContentResolver cr=getContentResolver();
        //Fetch inbox sms message from built in content provider
        Cursor c=cr.query(inboxUri, null,null,null,null);
        while (c.moveToNext()){
            String Number= c.getString(c.getColumnIndexOrThrow("address")).toString();
            String Body=c.getString(c.getColumnIndexOrThrow("body")).toString();
            smsList.add("Number: "+Number + "\n"+"" +Body );
        }
        c.close();
        ArrayAdapter adapter =new ArrayAdapter(this,android.R.layout.simple_list_item_1,smsList);
        listView.setAdapter(adapter);
    }
}
