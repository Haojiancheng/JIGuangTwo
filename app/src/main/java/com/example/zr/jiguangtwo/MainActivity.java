package com.example.zr.jiguangtwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TAG";

    private String fuserID = "330909199301271234";
    private String ename = "LinH";
    private String dhometown = "Dongying";
    //    //Token转大写
    private String cToken = "test25Mb".toUpperCase();
    private String bTimestamp = "Timestamp";
    private String aphone = "18814868888";
    private String myy="MzUzMTY2NjYzMzYxNjM2MjM2NjEzMDYyNjUzNTY2MzQzNzYxNjQzOTM2NjY2MTYxNjYzODM0MzIzMTY1Mzc2MjMyNjE2NTMwMzc2NTY1MzQzMTY2MzAzMjYzNjEzMzM4MzEzNTM2NjMzNzY0MzEzOTYyNjIzNjM4Mzg2NjMwMzU=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String qianming = QianMing.qianming(fuserID, ename, dhometown, cToken, bTimestamp, aphone);
        Log.e(TAG, "" + qianming);
        if (myy.equals(qianming)) {
            Log.e(TAG, "yiyang");
        } else {
            Log.e(TAG, "No");
        }

    }
}
