package com.example.admin.nyproject.ui.main.presenter;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.example.admin.nyproject.ui.main.MainContract;

public class MainPresenter implements MainContract.Presenter {

    private static final float TO_METER = 100f;
    private static final int MAX_LENGTH_OF_WIDTH = 2;

    @NonNull
    private MainContract.View mView;

    public MainPresenter(@NonNull MainContract.View view) {
        mView = view;
    }

    //region MainContract.Presenter
    @Override
    public void calculate(@NonNull String width, String length, String thickness) {
        if (TextUtils.isEmpty(length)) {
            mView.showEmptyLengthError();
            return;
        }

        if (TextUtils.isEmpty(thickness)) {
            mView.showEmptyThicknessError();
            return;
        }

        try {
            float lengthFloat = Float.parseFloat(length);
            float thicknessFloat = Float.parseFloat(thickness);
            float widthFloat = Float.parseFloat(width);
            float sum = (widthFloat / TO_METER) * lengthFloat * (thicknessFloat / TO_METER);
            mView.setResultOfCalculation(String.valueOf(sum));
        } catch (NumberFormatException ignored) {
            mView.showWrongWidthError();
        }
    }

    @Override
    public void handleWidth(@NonNull String width) {
        try {
            if (width.trim().length() == MAX_LENGTH_OF_WIDTH) {
                int value = Integer.parseInt(width);
                mView.addWidth(value);
            }
        } catch (NumberFormatException e) {
            mView.showWrongWidthError();
        }
    }
    //endregion
}
