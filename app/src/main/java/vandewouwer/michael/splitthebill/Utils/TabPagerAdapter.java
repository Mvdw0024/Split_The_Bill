package vandewouwer.michael.splitthebill.Utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import vandewouwer.michael.splitthebill.Fragments.AboutFragment;
import vandewouwer.michael.splitthebill.Fragments.BillFragment;
import vandewouwer.michael.splitthebill.Fragments.PrefFragment;

public class TabPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] fragments = {BillFragment.newInstance(), PrefFragment.newInstance(), AboutFragment.newInstance()};

    public TabPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "The Bill";
            case 1:
                return "Settings";
            case 2:
                return "About";
        }
        return null;
    }
}
