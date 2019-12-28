package com.example.apptodolistretrofit08102019.repository;

import com.example.apptodolistretrofit08102019.api.ApiRequest;
import com.example.apptodolistretrofit08102019.api.RetrofitInit;
import com.example.apptodolistretrofit08102019.model.Response;
import com.example.apptodolistretrofit08102019.model.Sinhvien;

import java.util.List;

import io.reactivex.Flowable;

public class MonanRepository{

    private ApiRequest apiRequest;
    private static MonanRepository monanRepository = null;

    private MonanRepository(){
        apiRequest = RetrofitInit.getInStance();
    }
    public static MonanRepository getInstance(){
        if (monanRepository == null){
            monanRepository = new MonanRepository();
        }
        return monanRepository;
    }

    public Flowable<Response<List<Sinhvien>>> getSinhvien(){
        return apiRequest.getListSinhvien();
    }
}
