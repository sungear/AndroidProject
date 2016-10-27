package be.interface3.ssingh.contentprovider;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int PERMISSIONS_REQUEST_READ_CONTACTS;

    private Uri uri;
    private  ContentResolver cr;
    private Cursor c;

    private ArrayList<String> contacts;
    private String name;

    Button btn_main_getContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_main_getContacts = (Button) findViewById(R.id.btn_main_getContacts);

        btn_main_getContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
                    if(!ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.READ_CONTACTS)){
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_CONTACTS}, PERMISSIONS_REQUEST_READ_CONTACTS);
                    }
                }
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
                    contacts = ReadContacts();
                    showContacts(contacts);
                }
            }
        });

    }

//    public void onRequestPermissionResult(int requestCode, String[] permissions, int[] grantResults) {
//        if (requestCode == PERMISSIONS_REQUEST_READ_CONTACTS) {
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                showContacts();
//            }
//            else {
//                Toast.makeText(getApplicationContext(), "Accorder les droits pour éliminer", Toast.LENGTH_SHORT);
//            }
//        }
//    }

    private ArrayList<String> ReadContacts() {
        contacts = new ArrayList<String>();
        uri = ContactsContract.Contacts.CONTENT_URI;
        cr = getContentResolver();
        c = cr.query(uri, null, null, null, null);

        if (c.moveToFirst()) {
            do {
                name = c.getString((c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
                contacts.add(name);
            } while (c.moveToNext());
        }
        c.close();

        return contacts;
    }

    private void showContacts(ArrayList<String> contacts) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
//            requestPermissions(new String[] {Manifest.permission.READ_CONTACTS }, PERMISSIONS_REQUEST_READ_CONTACTS);
//        }

        for (int i = 0; i < contacts.size(); i++) {
            String contact = contacts.get(i);
            Toast.makeText(getApplicationContext(), contact, Toast.LENGTH_SHORT).show();
        }
    }
}
