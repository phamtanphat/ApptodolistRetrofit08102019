package com.example.apptodolistretrofit08102019.viewmodel;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.example.apptodolistretrofit08102019.model.Response;
import com.example.apptodolistretrofit08102019.model.Sinhvien;
import com.example.apptodolistretrofit08102019.repository.MonanRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MonanViewModel extends ViewModel implements LifecycleObserver {

    private CompositeDisposable disposable = new CompositeDisposable();
    private MonanRepository monanRepository = MonanRepository.getInstance();

    public MutableLiveData<Response<List<Sinhvien>>> dataSinhvien = new MutableLiveData<>();
    public void getDataSinhvien(){
        disposable.add(monanRepository
                            .getSinhvien()
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Consumer<Response<List<Sinhvien>>>() {
                                @Override
                                public void accept(Response<List<Sinhvien>> listResponse) throws Exception {
                                    dataSinhvien.setValue(listResponse);
                                }
                            }));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void clearSubscription(){
        if (disposable != null){
            disposable.clear();
        }
    }

}
