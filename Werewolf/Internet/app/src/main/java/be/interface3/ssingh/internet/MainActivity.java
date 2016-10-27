package be.interface3.ssingh.internet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements CustomAsyncTask.CustomInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomAsyncTask task = new CustomAsyncTask(this);
        task.execute();

        JSONObject jsonObject = new JSONObject();
    }
}
