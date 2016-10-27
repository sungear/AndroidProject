package be.interface3.ssingh.phonecall;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Uri phonenumber;
    private EditText text_main_phone;
    private Button button_main_call;
    private Intent callIntent;
    private int MY_PERMISSIONS_REQUEST_CALL_PHONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_main_phone = (EditText) findViewById(R.id.text_main_phone);
        button_main_call = (Button) findViewById(R.id.button_main_call);

        button_main_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phonenumber = Uri.parse("tel:" + text_main_phone.getText().toString());
                //callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(phonenumber);
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    if(!ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.CALL_PHONE)){
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST_CALL_PHONE);
                    }
                }
                startActivity(callIntent);
            }
        });
    }

}
