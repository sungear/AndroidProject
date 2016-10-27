package be.interface3.ssingh.exo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import be.interface3.ssingh.exo.model.User;

public class MainActivity extends AppCompatActivity {

    private Intent signUpIntent;
    private Intent signInIntent;

    private FileInputStream inputStream;
    private BufferedReader reader;
    private Boolean isItChecked;
    private String checked;
    private String username;

    private int duration;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            Bundle extras = getIntent().getExtras();
            Log.i("User package", extras.getString(SignUpFormActivity.USER));
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }

        duration = 10;

        isItChecked = false;
    }

    public void doOnClick(View v) {
        switch (v.getId()) {
            case R.id.button_main_signUp :
                goToNewActivity(signInIntent, SignUpFormActivity.class );
                break;

            case R.id.button_main_signIn :
                try {
                    readFile();;
                }
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

                if (isItChecked) {
                    goToNewActivity(signInIntent, ConnectedActivity.class );
                    showToast("Welcome " + username, duration);
                }

                else {
                    goToNewActivity(signInIntent, SignInFormActivity.class );
                    showToast("Going to Sign in Form", duration);
                }
                break;
        }
    }

    private void readFile() throws FileNotFoundException, IOException{
        inputStream = openFileInput((SignInFormActivity.FILENAME));
        reader = new BufferedReader((new InputStreamReader(inputStream)));

        checked = reader.readLine();
        isItChecked = Boolean.parseBoolean(checked);
        username = reader.readLine();

        reader.close();
        inputStream.close();
    }

    private void showToast(String message, int duration) {
        Context myContext = getApplicationContext();
        toast = Toast.makeText(myContext, message, duration);
        toast.show();
    }

    private void goToNewActivity(Intent intent, Class<?> newContext) {
        Context myContext = getApplicationContext();
        intent = new Intent(myContext, newContext);
        startActivity(intent);
    }
}
