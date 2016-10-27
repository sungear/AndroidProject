package be.interface3.ssingh.persistancepreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button button_main_login;

    private EditText text_main_username;
    private EditText text_main_password;
    private CheckBox checkBox_main_remember;

    private Intent loggingIntent;
    private SharedPreferences prefs;
    private  SharedPreferences.Editor editor;

    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    private static final String isItChecked = "isItChecked";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_main_login = (Button) findViewById(R.id.button_main_login);

        text_main_username = (EditText) findViewById(R.id.text_main_username);
        text_main_password = (EditText) findViewById(R.id.text_main_password);
        checkBox_main_remember = (CheckBox) findViewById(R.id.checkbox_main_remenber);

        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        text_main_username.setText(prefs.getString(USERNAME, ""));
        text_main_password.setText(prefs.getString(PASSWORD, ""));
        checkBox_main_remember.setChecked(prefs.getBoolean(isItChecked, false));

        button_main_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox_main_remember.isChecked()){
                    editor = prefs.edit();
                    editor.putString(USERNAME, text_main_username.getText().toString());
                    editor.putString(PASSWORD, text_main_password.getText().toString());
                    editor.putBoolean(isItChecked, true);
                    editor.apply();
                }
                loggingIntent = new Intent(MainActivity.this, SideActivity.class);
                startActivity(loggingIntent);
            }
        });
    }
}
