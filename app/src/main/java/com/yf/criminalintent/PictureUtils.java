package com.yf.criminalintent;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

/**
 * Created by YF on 2016/6/30.
 */
public class PictureUtils {

    //先确认屏幕尺寸，在按此缩放图像
    public static Bitmap getScaledBitmap(String path ,Activity activity){
        Point size = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(size);

        return getScaledBitmap(path , size.x , size.y);
    }


    public static Bitmap getScaledBitmap(String path , int destWidth , int destHeight){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path , options);

        float srcWidth = options.outWidth;
        float srcHeight = options.outHeight;

        int inSampleSize = 1;
        if (srcHeight > destHeight || srcWidth > destWidth){
            if (srcWidth > srcHeight){
                inSampleSize = Math.round(srcHeight / destHeight);
            }
            else{
                inSampleSize = Math.round(srcWidth / destWidth);
            }
        }

        options = new BitmapFactory.Options();
        options.inSampleSize = inSampleSize;

        return BitmapFactory.decodeFile(path , options);

    }



}
