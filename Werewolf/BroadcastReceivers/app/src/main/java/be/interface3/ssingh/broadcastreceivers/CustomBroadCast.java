package be.interface3.ssingh.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by s.singh on 13/09/2016.
 */
public class CustomBroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Test", Toast.LENGTH_SHORT).show();
        Intent intentlog = new Intent(context, MainActivity.class);
        intentlog.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intentlog);
    }
}
