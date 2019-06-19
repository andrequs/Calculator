package com.example.admin.nyproject.core.ui;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.nyproject.App;
import com.example.admin.nyproject.core.annotation.LateInit;
import com.example.admin.nyproject.core.handlers.UiNavigation;


public abstract class BaseActivity extends AppCompatActivity implements UiNavigation {

    @LateInit
    protected App mApp;

    @LayoutRes
    protected abstract int getLayoutRes();

    protected abstract void initView();

    //region AppCompatActivity
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mApp = (App) getApplication();

        setContentView(getLayoutRes());

        initView();
    }
    //endregion

    //region UiNavigation
    @Override
    public void replaceFragment(@IdRes int containerViewId, @NonNull Fragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(containerViewId, fragment, fragment.getClass().getName());
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(fragment.getClass().getName());
        }

        fragmentTransaction.commitAllowingStateLoss();
    }
    //endregion
}
