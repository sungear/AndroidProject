package be.interface3.ssingh.preferenceactivity;

import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PreferencesActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences_config);
    }
}
