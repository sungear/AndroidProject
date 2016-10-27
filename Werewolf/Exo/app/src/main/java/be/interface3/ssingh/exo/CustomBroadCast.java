package be.interface3.ssingh.exo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by s.singh on 14/09/2016.
 */
public class CustomBroadCast extends BroadcastReceiver {

    private FileInputStream inputStream;
    private BufferedReader reader;
    private Boolean isItChecked;
    private String checked;
    private String username;

    private Toast toast;

    private Intent loggingIntent;

    private Boolean isAirplaneModeOn;

    @Override
    public void onReceive(Context context, Intent intent) {
        isAirplaneModeOn = Settings.System.getInt(context.getContentResolver(), Settings.System.AIRPLANE_MODE_ON, 0) != 0;

        if (isAirplaneModeOn) {
            showToast(context, "Airplane Mode Activated", Toast.LENGTH_SHORT);
            try {
                goToConnectedActivity(context);
            }
            catch (FileNotFoundException e) {
                goToSignInActivity(context);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        else {
            showToast(context, "Airplane Mode Deactivated", Toast.LENGTH_SHORT);
        }
    }

    private void goToConnectedActivity(Context context) throws FileNotFoundException, IOException {
        inputStream = context.getApplicationContext().openFileInput((SignInFormActivity.FILENAME));
        reader = new BufferedReader((new InputStreamReader(inputStream)));

        checked = reader.readLine();
        isItChecked = Boolean.parseBoolean(checked);
        username = reader.readLine();

        reader.close();
        inputStream.close();

        if (isItChecked) {
            showToast(context,"Welcome " + username, Toast.LENGTH_SHORT );
            goToNewActivity(context, loggingIntent, ConnectedActivity.class);
        }
    }

    private void goToSignInActivity(Context context) {
        showToast(context, "Going to Sign in Form", Toast.LENGTH_SHORT);
        goToNewActivity(context, loggingIntent, SignInFormActivity.class);
    }

    private void goToNewActivity(Context context, Intent intent, Class<?> newContext) {
        Context myContext = context.getApplicationContext();
        intent = new Intent(myContext, newContext);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    private void showToast(Context context, String message, int duration) {
        Context myContext = context.getApplicationContext();
        toast = Toast.makeText(myContext, message, duration);
        toast.show();
    }
}
