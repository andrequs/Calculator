package com.example.admin.nyproject.main.view;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.admin.nyproject.R;
import com.example.admin.nyproject.core.annotation.LateInit;
import com.example.admin.nyproject.core.ui.BaseFragment;
import com.example.admin.nyproject.main.MainContract;
import com.example.admin.nyproject.main.presenter.MainPresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainFragment extends BaseFragment implements MainContract.View {

    @LateInit
    private MainContract.Presenter mPresenter;

    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    //region Fragment
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new MainPresenter(this);
    }
    //endregion

    //region BaseFragment
    @LayoutRes
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @NonNull
    @Override
    protected Unbinder bindView(@NonNull View view) {
        return ButterKnife.bind(this, view);
    }

    @Override
    protected void initView() {

    }
    //endregion
}
