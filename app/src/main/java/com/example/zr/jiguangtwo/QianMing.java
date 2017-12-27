package com.example.zr.jiguangtwo;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zr on 2017/12/27.
 */

public class QianMing {

//    private static final String TAG = "TAG";

    public static String qianming(String fuserID, String ename, String dhometown, String cToken, String bTimestamp, String aphone) {
        String key;
        String value;
        /**
         * 装入HashMap集合
         */
        HashMap<String, String> map = new HashMap<>();
        map.put("name", ename);
        map.put("hometown", dhometown);
        map.put("userID", fuserID);
        map.put("phone", aphone);

        /**
         *
         * 排序
         */
        List<Map.Entry<String, String>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return (o1.getKey()).toString().compareTo(o2.getKey().toString());
            }
        });
        String id;
        for (int i = 0; i < list.size(); i++) {
            id = list.get(i).toString();

//            Log.e(TAG, id + "");
        }


        /**
         * 字符拼接
         */
        StringBuffer buffer = new StringBuffer();
        for (int j = 0; j < list.size(); j++) {
            key = list.get(j).getKey();
            value = list.get(j).getValue();
            buffer.append(key);
            buffer.append(value);
        }

        String str = cToken.toUpperCase() + buffer + bTimestamp;
//        Log.e(TAG, "" + str);

        /**
         * 做SHA256签名
         */
        String sha256 = SHA256Encrypt.bin2hex("" + str).toLowerCase();
//        Log.e(TAG, "" + sha256);


        /**
         * 16进制转换
         */
        String zhuan16 = Zhuanhuan16.str2HexStr(sha256);
//        Log.e(TAG, "" + zhuan16);

        /**
         * 转换Base64
         */
        String sign = Base64Utils.getBase64(zhuan16);
//        Log.e(TAG, "" + sign);

        return sign.toString().trim();
    }

}
