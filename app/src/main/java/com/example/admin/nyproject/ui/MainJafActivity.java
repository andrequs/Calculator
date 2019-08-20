package com.example.admin.nyproject.ui;

import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;

import com.example.admin.nyproject.R;
import com.example.admin.nyproject.core.ui.BaseActivity;
import com.example.admin.nyproject.ui.main.view.MainFragment;
import com.example.admin.nyproject.ui.save.view.SaveFragment;

public class MainJafActivity extends BaseActivity implements MainJafNavigation {

    //region BaseActivity
    @LayoutRes
    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main_jaf;
    }

    @Override
    protected void initView() {
        showMainFragment();
    }
    //endregion

    //region MainJafNavigation
    @Override
    public void showMainFragment() {
        replaceFragment(getFragmentContainerId(), MainFragment.newInstance(), false);
    }

    @Override
    public void showSaveFragment() {
        replaceFragment(getFragmentContainerId(), SaveFragment.newInstance(), true);
    }
    //endregion

    //region Utility API
    @IdRes
    private int getFragmentContainerId() {
        return R.id.framelayout_activity_main_jaf_container;
    }
    //endregion
}
