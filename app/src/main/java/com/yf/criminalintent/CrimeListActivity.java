package com.yf.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by YF on 2016/6/12.
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}