package be.interface3.ssingh.persistancepreferences;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class SideActivity extends AppCompatActivity {
    private TextView textview_side_username;
    private TextView textview_side_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side);

        textview_side_username = (TextView) findViewById(R.id.textview_side_username);
        textview_side_password = (TextView) findViewById(R.id.textview_side_password);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        textview_side_username.setText(prefs.getString("username", ""));
        textview_side_password.setText(prefs.getString("password", ""));
    }
}
