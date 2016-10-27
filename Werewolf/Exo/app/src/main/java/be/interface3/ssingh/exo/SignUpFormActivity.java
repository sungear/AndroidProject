package be.interface3.ssingh.exo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import be.interface3.ssingh.exo.db.UserDAO;
import be.interface3.ssingh.exo.model.User;

public class SignUpFormActivity extends AppCompatActivity {

    private EditText editText_signUp_username;
    private EditText editText_signUp_password;

    private int duration;
    private Toast toast;

    private User u;
    public static final String USER = "User";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_form);

        editText_signUp_username = (EditText) findViewById(R.id.editText_signUp_username);
        editText_signUp_password = (EditText) findViewById(R.id.editText_signUp_password);

        duration = 10;
    }

    public void doOnClick(View v) {
        if (editText_signUp_username.getText().toString().length() >= 1 &&
                editText_signUp_password.getText().toString().length() >= 1) {

            UserDAO dao = new UserDAO(getApplicationContext());
            User testUser = checkIfUserExist(dao);

            if (testUser == null) {
                createUser(dao);
                showToast("You have successfully signed up", duration);
            }

            else {
                showToast("This username exists already", duration);
            }
        }
        else {
            showToast("The password or the username is incorrect", duration);
        }
    }

    private User checkIfUserExist(UserDAO dao) {
        dao = dao.openReadable();
        User testUser = dao.getUserByName(editText_signUp_username.getText().toString());
        return testUser;
    }

    private void createUser(UserDAO dao) {
        u = new User();
        u.setUsername(editText_signUp_username.getText().toString());
        u.setPassword(editText_signUp_password.getText().toString());
        dao = dao.openWritable();
        dao.Insert(u);
        dao.close();
    }

    private void showToast(String message, int duration) {
        Context myContext = getApplicationContext();
        toast = Toast.makeText(myContext, message, duration);
        toast.show();
    }
}
