package be.interface3.ssingh.radiobutton2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by s.singh on 18/10/2016.
 */
public class LsAdapter extends BaseAdapter{

    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        // TODO Auto-generated method stub
        return 20;
    }

    @Override
    public int getItemViewType(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int arg0, View arg1, ViewGroup arg2) {
        ViewHolder vh;
        vh= new ViewHolder();

        if(arg1==null )
        {
            LayoutInflater mInflater = (LayoutInflater) arg2.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            arg1= mInflater.inflate(R.layout.listview_radio_raw, arg2,false);
            vh.iv1= (ImageView)arg1.findViewById(R.id.ivs);
            vh.rb= (RadioButton) arg1.findViewById(R.id.radioButton1);
            vh.tv= (TextView)arg1.findViewById(R.id.textView1);

        }
        else
        {
            arg1.setTag(vh);
        }
        //set data to textview, radiobutton and imageview.
        return arg1;
    }

    static class ViewHolder
    {
        TextView tv;
        RadioButton rb;
        ImageView iv1;
    }
}
