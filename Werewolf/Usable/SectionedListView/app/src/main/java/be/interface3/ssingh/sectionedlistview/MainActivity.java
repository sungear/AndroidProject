package be.interface3.ssingh.sectionedlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView lv_main_list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lv_main_list = (ListView) findViewById(R.id.lv_main_list);

        // if extending Activity
        //setContentView(R.layout.activity_main);

        // 1. pass context and data to the custom adapter
        MyAdapter adapter = new MyAdapter(this, generateData());

        // if extending Activity 2. Get ListView from activity_main.xml
        //ListView listView = (ListView) findViewById(R.id.listview);

        // 3. setListAdapter
        //listView.setAdapter(adapter); if extending Activity
        lv_main_list.setAdapter(adapter);
    }

    private ArrayList<Model> generateData(){
        ArrayList<Model> models = new ArrayList<Model>();
        models.add(new Model("Group Title"));
        models.add(new Model(R.drawable.ic_add_black_24dp,"Menu Item 1","1"));
        models.add(new Model(R.drawable.ic_add_black_24dp,"Menu Item 2","2"));
        models.add(new Model(R.drawable.ic_add_black_24dp,"Menu Item 3","12"));

        return models;
    }
}
