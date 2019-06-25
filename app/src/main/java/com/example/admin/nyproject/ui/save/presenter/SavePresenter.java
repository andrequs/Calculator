package com.example.admin.nyproject.ui.save.presenter;

import android.support.annotation.NonNull;

import com.example.admin.nyproject.data.local.db.JafDao;
import com.example.admin.nyproject.data.local.specification.DefaultSpecificationLocalRepository;
import com.example.admin.nyproject.data.local.specification.SpecificationLocalRepository;
import com.example.admin.nyproject.ui.save.SaveContract;

import java.util.Collections;

public class SavePresenter implements SaveContract.Presenter {

    @NonNull
    private SaveContract.View mView;

    @NonNull
    private SpecificationLocalRepository mSpecificationLocalRepository;

    public SavePresenter(@NonNull SaveContract.View view,
                         @NonNull JafDao jafDao) {
        mView = view;
        mSpecificationLocalRepository = new DefaultSpecificationLocalRepository(jafDao);
    }

    //region SaveContract.Presenter
    @Override
    public void loadSpecificationData() {
        // TODO: load data from database from SpecificationLocalRepository

        mView.showSpecificationData(Collections.emptyList());
    }
    //endregion
}
