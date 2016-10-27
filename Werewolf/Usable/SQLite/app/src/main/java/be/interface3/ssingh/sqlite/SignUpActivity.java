package be.interface3.ssingh.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import be.interface3.ssingh.sqlite.db.UserDAO;
import be.interface3.ssingh.sqlite.model.User;

public class SignUpActivity extends AppCompatActivity {

    private EditText editText_signUp_username;
    private EditText editText_signUp_password;

    private int duration;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editText_signUp_username = (EditText) findViewById(R.id.editText_signUp_username);
        editText_signUp_password = (EditText) findViewById(R.id.editText_signUp_password);

        duration = 10;
    }

    public void doOnClick(View v) {
        if (editText_signUp_username.getText().toString().length() >= 1 &&
                editText_signUp_password.getText().toString().length() >= 1) {
            User u = new User();
            u.setUsername(editText_signUp_username.getText().toString());
            u.setPassword(editText_signUp_password.getText().toString());
            UserDAO dao = new UserDAO(getApplicationContext());
            dao = dao.openWritable();
            dao.Insert(u);
            dao.close();

            toast = Toast.makeText(SignUpActivity.this, "You have successfully signed up", duration );
            toast.show();
        }
        else {
            toast = Toast.makeText(SignUpActivity.this, "The password or the username is incorrect", duration );
            toast.show();
        }
    }
}
