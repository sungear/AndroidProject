package be.interface3.ssingh.exo;

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

import be.interface3.ssingh.exo.db.UserDAO;
import be.interface3.ssingh.exo.model.User;

public class ConnectedActivity extends AppCompatActivity {

    private Context myContext;
    private Intent leavingIntent;

    private int duration;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connected);

        Bundle extras = getIntent().getExtras();
        Log.i("User package", extras.getString(SignUpFormActivity.USER));

        duration = 10;
    }

    public void doOnClick(View v) {
        myContext = getApplicationContext();
        myContext.deleteFile(SignInFormActivity.FILENAME);

        showToast("Logging out", duration);
        goToNewActivity(leavingIntent, MainActivity.class);
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
