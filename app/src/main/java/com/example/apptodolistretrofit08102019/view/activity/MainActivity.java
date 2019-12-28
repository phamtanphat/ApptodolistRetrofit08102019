package com.example.apptodolistretrofit08102019.view.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.apptodolistretrofit08102019.R;
import com.example.apptodolistretrofit08102019.model.Response;
import com.example.apptodolistretrofit08102019.model.Sinhvien;
import com.example.apptodolistretrofit08102019.viewmodel.MonanViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    MonanViewModel monanViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        monanViewModel = ViewModelProviders.of(this).get(MonanViewModel.class);
        getLifecycle().addObserver(monanViewModel);
        observer();
        setListener();
    }

    private void observer() {
        monanViewModel.dataSinhvien.observe(this, new Observer<Response<List<Sinhvien>>>() {
            @Override
            public void onChanged(Response<List<Sinhvien>> listResponse) {
                Toast.makeText(MainActivity.this, listResponse.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void setListener() {
        monanViewModel.getDataSinhvien();

    }
}
