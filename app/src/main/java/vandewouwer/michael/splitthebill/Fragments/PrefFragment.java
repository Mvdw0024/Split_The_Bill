package vandewouwer.michael.splitthebill.Fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.preference.PreferenceFragmentCompat;

import vandewouwer.michael.splitthebill.R;


public class PrefFragment extends PreferenceFragmentCompat {

    public static PrefFragment newInstance() {
        return new PrefFragment();
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }
}