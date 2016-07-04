package com.yf.criminalintent;

import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by YF on 2016/6/12.
 */
public class CrimeListActivity extends SingleFragmentActivity implements CrimeListFragment.Callbacks, CrimeFragment.Callbacks{
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

//    //使用双面板布局
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_twopane;
//        return R.layout.activity_maserdetail;
    }


    @Override
    public void onCrimeSelected(Crime crime) {
        if (findViewById(R.id.datail_fragment_container) == null){
            Intent intent = CrimePagerActivity.newIntent(this , crime.getId());
            startActivity(intent);
        }
        else {
            Fragment newDetail = CrimeFragment.newInstance(crime.getId());

            getSupportFragmentManager().beginTransaction().replace(R.id.datail_fragment_container , newDetail).commit();
        }
    }

    @Override
    public void onCrimeUpdated(Crime crime) {
        CrimeListFragment listFragment = (CrimeListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        listFragment.updateUI();
    }

}
