package be.interface3.ssingh.radiobutton2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView LSOne;
    public static int[] _intRadio = new int[20];
    LsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LSOne = (ListView) findViewById(R.id.LOne);
        adapter = new LsAdapter();

        LSOne.setAdapter(adapter);

    }
}
