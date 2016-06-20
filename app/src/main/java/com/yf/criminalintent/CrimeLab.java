package com.yf.criminalintent;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.yf.criminalintent.database.CrimeBaseHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by YF on 2016/6/12.
 */
public class CrimeLab {
    private static CrimeLab sCrimeLab;

//    private List<Crime> mCrimes;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    private CrimeLab(Context context){
        mContext = context.getApplicationContext();
        mDatabase = new CrimeBaseHelper(mContext).getWritableDatabase();

//        mCrimes = new ArrayList<>();
        //可以点击菜单栏添加crime记录
//        for (int i = 0 ; i < 100 ; i++){
//            Crime crime = new Crime();
//            crime.setTitle("Crime # " + i);
//            crime.setSolved(i % 2 == 0);
//            mCrimes.add(crime);
//        }

    }

    public List<Crime> getCrimes(){
//        return mCrimes;
        return new ArrayList<>();
    }

    public Crime getCrime(UUID id){
//        for (Crime crime : mCrimes){
//            if (crime.getId().equals(id)){
//                return crime;
//            }
//        }
        return null;
    }

    public static CrimeLab get(Context context){
        if (sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    //手动添加crime记录
    public void addCrime(Crime c){
//        mCrimes.add(c);
    }
}
