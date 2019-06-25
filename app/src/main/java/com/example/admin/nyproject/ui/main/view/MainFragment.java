package com.example.admin.nyproject.ui.main.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import com.example.admin.nyproject.R;
import com.example.admin.nyproject.core.annotation.LateInit;
import com.example.admin.nyproject.core.ui.BaseFragment;
import com.example.admin.nyproject.ui.MainJafNavigation;
import com.example.admin.nyproject.ui.main.MainContract;
import com.example.admin.nyproject.ui.main.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainFragment extends BaseFragment implements MainContract.View {

    @BindView(R.id.thicknessEditText)
    EditText mThicknessEditText;

    @BindView(R.id.lengthEditText)
    EditText mLengthEditText;

    @BindView(R.id.widthEditText)
    EditText mWidthEditText;

    @LateInit
    private MainContract.Presenter mPresenter;

    @Nullable
    private MainJafNavigation mNavigator;

    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    //region Fragment
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() instanceof MainJafNavigation) {
            mNavigator = ((MainJafNavigation) getActivity());
        }
    }

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

    //region Click handlers
    @OnClick(R.id.btnCreate)
    void onCreateButtonClickListener() {
        if (mNavigator != null) {
            mNavigator.showSaveFragment();
        }
    }

    @OnClick(R.id.btnRestore)
    void onRestoreButtonClickListener() {
        showToast("RESTORE");
    }

    @OnClick(R.id.btnDelete)
    void onDeleteButtonClickListener() {
        showToast("DELETE");
    }
    //endregion
}
