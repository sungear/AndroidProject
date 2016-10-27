package be.interface3.ssingh.notificationandsnackbar;

import android.app.Notification;
import android.app.NotificationManager;
import android.media.audiofx.BassBoost;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_main_signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("My notification tile");
        builder.setContentText("My notification text");
        builder.setSound(Settings.System.getUriFor(Settings.System.NOTIFICATION_SOUND));
        builder.setVibrate(new long[]{200, 200, 200, 200, 200});
        Notification notification = builder.build();

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1, notification);

        btn_main_signUp = (Button) findViewById(R.id.btn_main_signUp);
        btn_main_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(findViewById(android.R.id.content), "Testing Snackbar", 2500)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
    }
}
