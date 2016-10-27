package be.interface3.ssingh.lists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listView_main_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView_main_list = (ListView) findViewById(R.id.listView_main_list);

        String[] data = new String[] {"Bleach", "Naruto", "One Piece", "Hunter X Hunter", "Tokyo Ghouls",
                "Kateikyo Hitman Reborn", "Black Clover", "Shingeki no Kyoujin : Attack on Titan", "Gundam 00",
                "Ranma 1/2", "Dragon Ball GT", "Meitantei Conan", "Berserker", "Ghost Hunt", "Hyouka", "Soul Eater",
                "Soul Hunter", "Beyblade : Metal Fight", "Yu-Gi-Oh : Duel Master", "Hikaru no Go", "Slayers",};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.list_string, R.id.tv_list_string, data);

        if (listView_main_list != null) {
            listView_main_list.setAdapter(adapter);
        }
    }
}
