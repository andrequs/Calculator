package com.example.admin.nyproject.save.presenter;

import android.support.annotation.NonNull;

import com.example.admin.nyproject.save.SaveContract;

public class SavePresenter implements SaveContract.Presenter {

    @NonNull
    private SaveContract.View mView;

    public SavePresenter(@NonNull SaveContract.View view) {
        mView = view;
    }
}
