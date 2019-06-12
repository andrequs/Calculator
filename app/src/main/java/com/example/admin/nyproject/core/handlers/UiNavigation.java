package com.example.admin.nyproject.core.handlers;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

public interface UiNavigation {
    void replaceFragment(@IdRes int containerViewId, @NonNull Fragment fragment, boolean addToBackStack);
}
