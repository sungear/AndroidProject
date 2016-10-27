package be.interface3.ssingh.progressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CustomAsyncTask.CustomInterface{

    ProgressBar pb_main_progress;

    Button btn_main_text;
    TextView tv_main_text;
    EditText et_main_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb_main_progress = (ProgressBar) findViewById(R.id.pb_main_progress);

        btn_main_text = (Button) findViewById(R.id.btn_main_text);
        tv_main_text = (TextView) findViewById(R.id.tv_main_text);
        et_main_text = (EditText) findViewById(R.id.et_main_text);

        btn_main_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_main_text != null) {
                    String text = et_main_text.getText().toString();
                    tv_main_text.setText(text);
                }
            }
        });

        CustomAsyncTask task = new CustomAsyncTask(this);
        task.execute(1, 100);
    }

    @Override
    public void toastMassage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        Log.d("test", message);
    }

    @Override
    public void updateProgressbar(int progress) {
        pb_main_progress.setProgress(progress);
    }
}
