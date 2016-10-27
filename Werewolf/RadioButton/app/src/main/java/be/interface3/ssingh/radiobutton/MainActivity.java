package be.interface3.ssingh.radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //     RadioGroup  radioGroup  = (RadioGroup) findViewById(R.id.radioGroup);
        final List<String> saveItems = new ArrayList<>();

        String code = null, condition = null, valid = null;

        // save your values here to the ItemContent List. usign dummy values as of now
        for (int i = 1; i < 6; i++) {
            code = "CodeXYZ000" + i;
            condition = "Purchase More than Rs." + i + "00";
            valid = "Valid until Dec 30";
//            saveItems.add("Selection n°" + i);
            ItemContents.items.add("Selection n°" + i);
        }
        final CustomAdapter adapter = new CustomAdapter(this, R.layout.activity_main, ItemContents.items);
        ListView listView = (ListView) findViewById(R.id.radioGroup);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.setSelectedIndex(position);  // set selected position and notify the adapter
//                adapter.notifyDataSetChanged();
            }
        });
    }

//    private static ItemContents itemContents(int i, final String code, final String condition, final String valid) {
//
//        ItemContents itemContent = new ItemContents();
//        itemContent.setId(i);
//        itemContent.setmCode(code);
//        itemContent.setmCondition(condition);
//        itemContent.setmValid(valid);
//        return itemContent;
//
//    }
}
