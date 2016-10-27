package be.interface3.ssingh.radiobutton;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by s.singh on 18/10/2016.
 */
public class CustomAdapter extends ArrayAdapter<String> {
    int selectedIndex = -1;

    public CustomAdapter(Context context, int activity_radio_button, List<String> saveItems) {
        super(context, activity_radio_button, saveItems);
    }

    public void setSelectedIndex(int index) {
        selectedIndex = index;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.radio_button_item, null);
        }

        RadioButton rbSelect = (RadioButton) v
                .findViewById(R.id.radioButton);
        if(selectedIndex == position){  // check the position to update correct radio button.
            rbSelect.setChecked(true);
        }
        else{
            rbSelect.setChecked(false);
        }

        for (int i = 0; i < ItemContents.items.size(); i++) {
            TextView textCode = (TextView) v.findViewById(R.id.textCode);
            textCode.setText(ItemContents.items.get(i));
        }

//        ItemContents itemContents = getItem(position);

//        if (itemContents != null) {
//            TextView textCode = (TextView) v.findViewById(R.id.textCode);
//            TextView textCond = (TextView) v.findViewById(R.id.textCond);
//            TextView textValid = (TextView) v.findViewById(R.id.textValid);
//
//
//            textCode.setText(itemContents.getmCode());
//            textCond.setText(itemContents.getmCondition());
//            textValid.setText(itemContents.getmValid());
//        }

        return v;
    }
}
