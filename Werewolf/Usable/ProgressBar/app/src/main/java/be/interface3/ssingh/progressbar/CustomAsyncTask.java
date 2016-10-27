package be.interface3.ssingh.progressbar;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by s.singh on 19/09/2016.
 */
public class CustomAsyncTask extends AsyncTask<Integer, Integer, Integer> {

    public interface CustomInterface {
        void toastMassage(String message);
        void updateProgressbar(int progress);
    }

    private CustomInterface callback;

    public CustomAsyncTask(CustomInterface callback){
        this.callback = callback;
    }

    @Override
    protected void onPreExecute() {
        callback.toastMassage("Counting...");
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        callback.updateProgressbar(values[0]);
    }

    @Override
    protected void onPostExecute(Integer integer) {
        callback.toastMassage("Reached " + integer + " ! ");
    }

    @Override
    protected Integer doInBackground(Integer... params) {
        int i = params[0];
        while (i < params[1]) {
            i++;
            publishProgress(i);
            try {
                Thread.sleep(50);
            }
            catch (InterruptedException e) {
                Log.e("CAT", e.getLocalizedMessage());
            }
        }
        return i;
    }
}
