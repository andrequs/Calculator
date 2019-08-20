package com.example.admin.nyproject.core.handlers;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

public interface MessageHandler {
    void showToast(@NonNull String message);

    void showToast(@StringRes int message);
}
