package com.example.admin.nyproject.settings.presenter;

import android.support.annotation.NonNull;

import com.example.admin.nyproject.settings.SettingsContract;

public class SettingsPresenter implements SettingsContract.Presenter {

    @NonNull
    private SettingsContract.View mView;

    public SettingsPresenter(@NonNull SettingsContract.View view) {
        mView = view;
    }
}
