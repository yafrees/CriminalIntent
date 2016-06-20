package com.yf.criminalintent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.yf.criminalintent.database.CrimeBaseHelper;
import com.yf.criminalintent.database.CrimeCursorWrapper;
import com.yf.criminalintent.database.CrimeDbSchema;

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
//        return new ArrayList<>();
        List<Crime> crimes = new ArrayList<>();

        CrimeCursorWrapper cursor = queryCrimes(null , null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                crimes.add(cursor.getCrime());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return crimes;
    }



    //使用ContentValues，写入数据库
    private static ContentValues getContentValues(Crime crime){
        ContentValues values = new ContentValues();
        values.put(CrimeDbSchema.CrimeTable.Cols.UUID , crime.getId().toString());
        values.put(CrimeDbSchema.CrimeTable.Cols.TITLE , crime.getTitle());
        values.put(CrimeDbSchema.CrimeTable.Cols.DATE , crime.getDate().getTime());
        values.put(CrimeDbSchema.CrimeTable.Cols.SOLVED , crime.isSolved());

        values.put(CrimeDbSchema.CrimeTable.Cols.SUSPECT , crime.getSuspect());

        return values;
    }

    //查询Crime记录
//    private Cursor queryCrimes(String whereClause , String [] whereArgs){
    private CrimeCursorWrapper queryCrimes(String whereClause , String [] whereArgs ){
        Cursor cursor = mDatabase.query(
                CrimeDbSchema.CrimeTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );
//        return cursor;
        return new CrimeCursorWrapper(cursor);
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

        ContentValues values = getContentValues(c);
        mDatabase.insert(CrimeDbSchema.CrimeTable.NAME , null , values);
    }

    public Crime getCrime(UUID id){
//        for (Crime crime : mCrimes){
//            if (crime.getId().equals(id)){
//                return crime;
//            }
//        }
//        return null;

        CrimeCursorWrapper cursor = queryCrimes(CrimeDbSchema.CrimeTable.Cols.UUID + " = ?",
                new String[]{id.toString()});

        try {
            if (cursor.getCount() == 0){
                return null;
            }
            cursor.moveToFirst();
            return cursor.getCrime();
        }
        finally {
            cursor.close();
        }

    }

    //更新记录
    public void updateCrime(Crime crime){
        String uuidString = crime.getId().toString();
        ContentValues values = getContentValues(crime);

        mDatabase.update(CrimeDbSchema.CrimeTable.NAME ,
                values ,
                CrimeDbSchema.CrimeTable.Cols.UUID + " = ? " ,
                new String[]{uuidString});
    }
}
