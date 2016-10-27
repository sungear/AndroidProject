package be.interface3.ssingh.servicemusic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doOnClick(View v) {
        switch (v.getId()){
            case R.id.btn_main_play :
                MyIntentService.startActionPlay(getApplicationContext(), "dancing_faery");
                break;
            case R.id.btn_main_pause :
                MyIntentService.startActionPause(getApplicationContext(), "dancing_faery");
                break;
            case R.id.btn_main_stop :
                MyIntentService.startActionStop(getApplicationContext(), "dancing_faery");
                break;
        }
    }
}
