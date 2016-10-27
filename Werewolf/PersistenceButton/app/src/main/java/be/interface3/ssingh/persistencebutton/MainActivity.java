package be.interface3.ssingh.persistencebutton;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private EditText edittext_main_example;
    private Button button_main_save;
    private Button button_main_print;
    private Button button_main_delete;

    private Intent loggingIntent;

    public static final String filename = "myfile.dat";
    private FileOutputStream outputStream;
    private FileInputStream inputStream;
    private BufferedReader reader;
    private StringBuilder out;
    private CharSequence line;
    private int duration;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edittext_main_example = (EditText) findViewById(R.id.edittext_main_example);
        button_main_save = (Button) findViewById(R.id.button_main_save);
        button_main_print = (Button) findViewById(R.id.button_main_print);
        button_main_delete = (Button) findViewById(R.id.button_main_delete);

        button_main_save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {

                    if (edittext_main_example.getText().toString().length() >= 1){
                        outputStream = openFileOutput(filename, MainActivity.MODE_PRIVATE);
                        outputStream.write(edittext_main_example.getText().toString().getBytes());
                        outputStream.close();

                        duration = 10;
                        toast = Toast.makeText(MainActivity.this, "File saved", duration);
                        toast.show();
                    }
                    else {
                        duration = 10;
                        toast = Toast.makeText(MainActivity.this, "There's no message to save", duration);
                        toast.show();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        button_main_print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    inputStream = openFileInput(MainActivity.filename);
                    reader = new BufferedReader(new InputStreamReader(inputStream));
                    out = new StringBuilder();

                    while ((line = reader.readLine()) != null){
                        out.append(line);
                    }
                    reader.close();
                    inputStream.close();

                    duration = 10;
                    toast = Toast.makeText(MainActivity.this, out, duration);
                    toast.show();
                }
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                    duration = 10;
                    toast = Toast.makeText(MainActivity.this, "There's no saved file", duration);
                    toast.show();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        });

        button_main_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context myContext = getApplicationContext();
                myContext.deleteFile(filename);
                duration = 10;
                toast = Toast.makeText(MainActivity.this, "File deleted", duration);
                toast.show();
            }
        });
    }
}
