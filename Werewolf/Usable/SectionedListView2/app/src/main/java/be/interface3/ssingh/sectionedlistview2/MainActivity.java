package be.interface3.ssingh.sectionedlistview2;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        SectionListView sectionListView = new SectionListView();
//    }
    private CustomAdapter mAdapter;
    private ListView lv_main_list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lv_main_list = (ListView) findViewById(R.id.lv_main_list);

        mAdapter = new CustomAdapter(this);
        for (int i = 1; i < 30; i++) {
            mAdapter.addItem("Row Item #" + i);
            if (i % 4 == 0) {
                mAdapter.addSectionHeaderItem("Section #" + i);
            }
        }
        lv_main_list.setAdapter(mAdapter);
    }
}
