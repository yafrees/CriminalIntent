package com.yf.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

@Deprecated

public class CrimeActivity extends /*FragmentActivity*/ SingleFragmentActivity {

    private static final String EXTRA_CRIME_ID = "com.yf.criminalintent.crime_id";

    public static Intent newIntent(Context packageContext , UUID crimeId){
        Intent intent = new Intent(packageContext , CrimeActivity.class);
        intent.putExtra(EXTRA_CRIME_ID , crimeId);
        return intent;
    }


    @Override
    protected Fragment createFragment() {
//        return new CrimeFragment();

        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(crimeId);


    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fragment);
//
//        FragmentManager fm = getSupportFragmentManager();
//        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
//
//        if (fragment == null){
//            fragment = new CrimeFragment();
//            fm.beginTransaction()
//                    .add(R.id.fragment_container , fragment)
//                    .commit();
//        }
//    }


}
