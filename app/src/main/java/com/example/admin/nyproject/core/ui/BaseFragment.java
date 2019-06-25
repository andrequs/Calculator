package com.example.admin.nyproject.core.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.admin.nyproject.App;
import com.example.admin.nyproject.core.annotation.LateInit;
import com.example.admin.nyproject.core.handlers.MessageHandler;

import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment implements MessageHandler {

    @LateInit
    protected App mApp;

    @Nullable
    private Unbinder mUnBinder;

    @LayoutRes
    protected abstract int getLayoutId();

    @NonNull
    protected abstract Unbinder bindView(@NonNull View view);

    protected abstract void initView();

    //region Fragment
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mApp = (App) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        mUnBinder = bindView(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
    }
    //endregion

    //region MessageHandler
    @Override
    public void showToast(@NonNull String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
    //endregion
}
