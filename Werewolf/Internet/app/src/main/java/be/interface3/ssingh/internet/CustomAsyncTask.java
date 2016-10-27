package be.interface3.ssingh.internet;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by s.singh on 19/09/2016.
 */
public class CustomAsyncTask extends AsyncTask<String, Void, String> {
    JSONObject data = null;
    String city;

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Log.i("result", result);
    }

    @Override
    protected String doInBackground(String... params) {
        String result = "";
        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=Bsrussels,BE&appid=3f5d897a6e9ff9ddebcb422c14ae31d4");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder out = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null){
                out.append(line);
            }
            result += out;
            reader.close();
            inputStream.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public interface CustomInterface {
    }

    private CustomInterface callback;

    public CustomAsyncTask(CustomInterface callback){
        this.callback = callback;
    }
}