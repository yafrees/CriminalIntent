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

//    //使用双面板布局
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_twopane;
    }


}
