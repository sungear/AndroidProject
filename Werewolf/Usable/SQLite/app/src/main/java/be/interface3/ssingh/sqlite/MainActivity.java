package be.interface3.ssingh.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Intent signUpIntent;
    private Intent signInIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doOnClick(View v) {
        switch (v.getId()) {
            case R.id.button_main_signUp :
                signUpIntent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(signUpIntent);
                break;
            case R.id.button_main_signIn :
                signInIntent = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(signInIntent);
                break;

        }
    }
}
