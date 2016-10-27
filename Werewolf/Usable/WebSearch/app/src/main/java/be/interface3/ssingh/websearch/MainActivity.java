package be.interface3.ssingh.websearch;

import android.Manifest;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText text_main_url;
    private Button button_main_search;

    protected Intent searchIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_main_url = (EditText) findViewById(R.id.text_main_url);
        button_main_search = (Button) findViewById(R.id.button_main_search);

        button_main_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = text_main_url.getText().toString();
                searchIntent = new Intent(Intent.ACTION_SEARCH);
                searchIntent.putExtra(SearchManager.QUERY, query);

                startActivity(searchIntent);
            }
        });
    }
}
