package com.example.admin.nyproject.main.presenter;

import android.support.annotation.NonNull;

import com.example.admin.nyproject.main.MainContract;

public class MainPresenter implements MainContract.Presenter {

    @NonNull
    private MainContract.View mView;

    public MainPresenter(@NonNull MainContract.View view) {
        mView = view;
    }
}
