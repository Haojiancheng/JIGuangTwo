package com.example.zr.jiguangtwo;

import android.util.Base64;

import java.io.UnsupportedEncodingException;

/**
 * Created by zr on 2017/12/26.
 */

public class Base64Utils {
    public static String getBase64(String str) {
        String result = "";
        if( str != null) {
            try {
                result = new String(Base64.encode(str.getBytes("utf-8"), Base64.NO_WRAP),"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
