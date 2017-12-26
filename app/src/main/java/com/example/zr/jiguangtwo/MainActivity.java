package com.example.zr.jiguangtwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TAG";
    private TextView mtvi;
    private String fuserID = "330909199301271234";
    private String ename = "LinH";
    private String dhometown = "Dongying";
    //Token转大写
    private String cToken = "test25Mb".toUpperCase();
    private String bTimestamp="Timestamp";
    private String aphone="18814868888";
    private HashMap<String, String> map = new HashMap<>();
    private String myypj="TEST25MBhometownDongyingnameLinHphone18814868888userID330909199301271234Timestamp";
    private String myy="MzUzMTY2NjYzMzYxNjM2MjM2NjEzMDYyNjUzNTY2MzQzNzYxNjQzOTM2NjY2MTYxNjYzODM0MzIzMTY1Mzc2MjMyNjE2NTMwMzc2NTY1MzQzMTY2MzAzMjYzNjEzMzM4MzEzNTM2NjMzNzY0MzEzOTYyNjIzNjM4Mzg2NjMwMzU=";
    private String key;
    private String value;
    private String myy256="51ff3acb6a0be5f47ad96faaf8421e7b2ae07ee41f02ca38156c7d19bb688f05";
    private String myy16="35316666336163623661306265356634376164393666616166383432316537623261653037656534316630326361333831353663376431396262363838663035";
    private String yz16="35316666336163623661306265356634376164393666616166383432316537623261653037656534316630326361333831353663376431396262363838663035";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtvi = findViewById(R.id.mtvi);
        /**
         * 装入HashMap集合
         */
        map.put("name",ename );
        map.put("hometown", dhometown);
        map.put("userID", fuserID);
//        map.put("Token", cToken);
        map.put("phone",aphone);
//        map.put("Timestamp",bTimestamp);
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
          Map<String,String> map2=new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            id = list.get(i).toString();

            Log.e(TAG, id+"");
        }


        /**
         * 字符拼接
         */
        StringBuffer buffer = new StringBuffer();
        for (int j=0;j<list.size();j++) {
            key =list.get(j).getKey();
            value = list.get(j).getValue();
            buffer.append(key);
            buffer.append(value);
        }
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHH:mm:ss");
//        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
//        String str = formatter.format(curDate);
//        Log.e(TAG, "" + buffer + str);
        String str=cToken+buffer+bTimestamp;
        Log.e(TAG,""+str);
        if (myypj.equals(str)){
            Log.e(TAG,"yiyang");
        }else {
            Log.e(TAG,"No");
        }

        /**
         * 做SHA256签名
         */
        String sha256 = SHA256Encrypt.bin2hex(""+str).toLowerCase();
        Log.e(TAG, "" + sha256);
        if (myy256.equals(sha256)){
            Log.e(TAG,"yiyang");
        }else {
            Log.e(TAG,"No");
        }

        /**
         * 16进制转换
         */
        String zhuan16 = Zhuanhuan16.str2HexStr(sha256);
        Log.e(TAG, "" + zhuan16);
        if (yz16.equals(zhuan16)){
            Log.e(TAG,"yiyang");
        }else {
            Log.e(TAG,"No");
        }
        /**
         * 转换Base64
         */
        String sign = Base64Utils.getBase64(zhuan16);
        Log.e(TAG, "" + sign);

        if (myy.equals(sign)){
            Log.e(TAG,"yiyang");
        }else {
            Log.e(TAG,"No");
        }

    }
}
