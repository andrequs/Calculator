package com.example.admin.nyproject.ui.main.presenter;

import android.support.annotation.NonNull;

import com.example.admin.nyproject.ui.main.MainContract;

public class MainPresenter implements MainContract.Presenter {

    @NonNull
    private MainContract.View mView;

    public MainPresenter(@NonNull MainContract.View view) {
        mView = view;
    }

    //region MainContract.Presenter
    @Override
    public void handleWidth(@NonNull String width) {
        try {
            // According business logic, width should have only two digits
            if (width.trim().length() == 2) {
                int value = Integer.parseInt(width);
                mView.addWidth(value);
            }
        } catch (NumberFormatException e) {
            mView.showWrongWidthError();
        }
    }
    //endregion
}
