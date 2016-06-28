package com.yf.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by YF on 2016/6/6.
 */
public class Crime {

    //只读成员变量
    private UUID mId;
    private String mTitle;

    private Date mDate;
    private boolean mSolved;

    private String mSuspect;

    public Crime(){
        this(UUID.randomUUID());
//        mId = UUID.randomUUID();
//        mDate = new Date();
    }

    public Crime(UUID id){
        mId = id;
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public String getSuspect() {
        return mSuspect;
    }

    public void setSuspect(String suspect) {
        mSuspect = suspect;
    }

    //获取图片文件名
    public String getPhotoFileName(){
        return "IMG_" + getId().toString() + ".jpg";
    }
}
