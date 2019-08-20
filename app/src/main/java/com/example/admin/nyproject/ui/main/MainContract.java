package com.example.admin.nyproject.ui.main;

import android.support.annotation.NonNull;

public interface MainContract {
    interface View {
        void addWidth(int width);
        void showWrongWidthError();
    }

    interface Presenter {
        void handleWidth(@NonNull String width);
    }
}
