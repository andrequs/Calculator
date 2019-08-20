package com.example.admin.nyproject.ui.main;

import android.support.annotation.NonNull;

public interface MainContract {
    interface View {
        void addWidth(int width);

        void showWrongWidthError();

        void setResultOfCalculation(@NonNull String result);

        void showEmptyLengthError();

        void showEmptyThicknessError();
    }

    interface Presenter {
        void calculate(@NonNull String width, String length, String thickness);

        void handleWidth(@NonNull String width);
    }
}
