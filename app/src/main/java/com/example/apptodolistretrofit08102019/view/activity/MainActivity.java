package com.example.apptodolistretrofit08102019.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.apptodolistretrofit08102019.R;
import com.example.apptodolistretrofit08102019.api.RetrofitInit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RetrofitInit.getInStance().getSinhvien()
    }
}
