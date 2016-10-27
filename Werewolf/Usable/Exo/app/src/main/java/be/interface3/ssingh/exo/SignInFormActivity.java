package be.interface3.ssingh.exo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import be.interface3.ssingh.exo.db.UserDAO;
import be.interface3.ssingh.exo.model.User;

public class SignInFormActivity extends AppCompatActivity {

    private EditText editText_signIn_username;
    private EditText editText_signIn_password;
    private CheckBox checkBox_signIn_remember;

    private int duration;
    private Toast toast;

    private Intent loggingIntent;

    public static final String FILENAME = "myfile.dat";
    private FileOutputStream outputStream;
    private boolean isItChecked;
    private String checked;

    private String username;
    private String password;
    private String writingPsw;

    private User u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_form);

        editText_signIn_username = (EditText) findViewById(R.id.editText_signIn_username);
        editText_signIn_password = (EditText) findViewById(R.id.editText_signIn_password);
        checkBox_signIn_remember = (CheckBox) findViewById(R.id.checkbox_signIn_remenber);

        isItChecked = false;

        duration = 10;
    }

    public void doOnClick(View v) {
        if (editText_signIn_username.getText().toString().length() >= 1 &&
                editText_signIn_password.getText().toString().length() >= 1) {

            UserDAO dao = new UserDAO(SignInFormActivity.this);
            dao = dao.openReadable();
            u = dao.getUserByName(editText_signIn_username.getText().toString());
            dao.close();

            if (u != null) {
                username = u.getUsername();
                password = u.getPassword();
                writingPsw = editText_signIn_password.getText().toString();

                if (writingPsw.equals(password)) {
                    if (checkBox_signIn_remember.isChecked()) {
                        try {
                            writeFile();
                        }
                        catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    showToast("Welcome " + username, duration);
                    goToNewActivity(loggingIntent, ConnectedActivity.class, u);
                }
                else {
                    showToast("The password and the username don't match", duration);
                }
            }
            else {
                showToast("This username doesn't exist", duration);
            }
        }
        else {
            showToast("The password or the username is incorrect", duration);
        }
    }

    private void writeFile() throws FileNotFoundException, IOException{
        isItChecked = true;
        outputStream = openFileOutput(FILENAME, MainActivity.MODE_PRIVATE);
        checked = Boolean.toString(isItChecked);
        outputStream.write(checked.getBytes());
        outputStream.write(("\n" + username).getBytes());
        outputStream.close();
    }

    private void showToast(String message, int duration) {
        Context myContext = getApplicationContext();
        toast = Toast.makeText(myContext, message, duration);
        toast.show();
    }

    private void goToNewActivity(Intent intent, Class<?> newContext, User u) {
        Context myContext = getApplicationContext();
        intent = new Intent(myContext, newContext);
        intent.putExtra(SignUpFormActivity.USER, u.toString());
        startActivity(intent);
    }
}
