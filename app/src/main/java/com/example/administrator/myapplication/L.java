package com.example.administrator.myapplication;

import android.util.Log;

/**
 * Created by Administrator on 2018/4/27.
 */
public class L {
    public static boolean debug=true;
    public static final String TAG="Imooc_okhttp";
    public static void e(String msg){
        if(debug){
            Log.e(TAG,msg);
        }

    }
}
