package com.example.testapp.api.services;

import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.example.testapp.App;
import com.example.testapp.R;
import com.example.testapp.api.models.User;
import com.example.testapp.fragments.MapsFragment;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class UserService {
    private ElchargeService elchargeService;

    public UserService(ElchargeService elchargeService) {
        this.elchargeService = elchargeService;
    }

    public ElchargeService getElchargeService() {
        return elchargeService;
    }

    public void setElchargeService(ElchargeService elchargeService) {
        this.elchargeService = elchargeService;
    }

    public User login(CompositeDisposable disposable, User user)throws Exception{
        final Exception[] err = {null};
        disposable.add(elchargeService.getUserApi().login(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<Response<User>>() {
                    @Override
                    public void onSuccess(Response<User> response) {
                        err[0] = null;
                        try {
                            elchargeService.setToken(response.headers().get("Authorization"));
                            elchargeService.setUser(response.body());
                        }catch (Exception e){
                            err[0] = e;
                        }
                    }

                    @Override
                    public void onError(Throwable e){
                        err[0] = new Exception(e.getMessage());
                    }
                }));
        if (err[0] != null){
            throw new Exception(err[0]);
        }
        return elchargeService.getUser();
    }
}

//if (user != null) {
//        Toast toast = Toast.makeText(App.getAppContext(), "SUCCESS !", Toast.LENGTH_LONG);
//        toast.setGravity(Gravity.TOP,0,0);
////                                    View toastView = toast.getView();
////                                    toastView.setBackgroundColor(Color.TRANSPARENT);
//        toast.show();
//        getFragmentManager().beginTransaction().replace(R.id.container, new MapsFragment()).commit();
//        } else {
//        Toast toast = Toast.makeText(App.getAppContext(), "Login or Password is incorrect", Toast.LENGTH_LONG);
//        toast.setGravity(Gravity.TOP,0,0);
//        toast.show();
//        }