package com.example.admin.nyproject.save.view;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.admin.nyproject.R;
import com.example.admin.nyproject.core.annotation.LateInit;
import com.example.admin.nyproject.core.ui.BaseFragment;
import com.example.admin.nyproject.save.SaveContract;
import com.example.admin.nyproject.save.presenter.SavePresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SaveFragment extends BaseFragment implements SaveContract.View {

    @LateInit
    private SaveContract.Presenter mPresenter;

    public static SaveFragment newInstance() {
        Bundle args = new Bundle();
        SaveFragment fragment = new SaveFragment();
        fragment.setArguments(args);
        return fragment;
    }

    //region Fragment
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new SavePresenter(this);
    }
    //endregion

    //region BaseFragment
    @LayoutRes
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_settings;
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
