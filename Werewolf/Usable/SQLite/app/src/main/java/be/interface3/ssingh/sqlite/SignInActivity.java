package be.interface3.ssingh.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import be.interface3.ssingh.sqlite.db.UserDAO;
import be.interface3.ssingh.sqlite.model.User;

public class SignInActivity extends AppCompatActivity {

    private EditText editText_signIn_username;
    private EditText editText_signIn_password;

    private int duration;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        editText_signIn_username = (EditText) findViewById(R.id.editText_signIn_username);
        editText_signIn_password = (EditText) findViewById(R.id.editText_signIn_password);

        duration = 10;
    }

    public void doOnClick(View v) {
        if (editText_signIn_username.getText().toString().length() >= 1 &&
                editText_signIn_password.getText().toString().length() >= 1) {
            UserDAO dao = new UserDAO(SignInActivity.this);
            dao = dao.openReadable();
            User u = dao.getUserByName(editText_signIn_username.getText().toString());

            toast = Toast.makeText(SignInActivity.this, "Welcome " + u.getUsername(), duration);
            toast.show();
        }
        else {
            toast = Toast.makeText(SignInActivity.this, "The password or the username is incorrect", duration);
            toast.show();
        }
    }
}
