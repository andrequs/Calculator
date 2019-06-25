package com.example.admin.nyproject.data.local.specification;

import android.support.annotation.NonNull;

import com.example.admin.nyproject.data.local.db.JafDao;
import com.example.admin.nyproject.data.model.SpecificationData;

import java.util.List;

public class DefaultSpecificationLocalRepository implements SpecificationLocalRepository {

    @NonNull
    private JafDao mJafDao;

    public DefaultSpecificationLocalRepository(@NonNull JafDao jafDao) {
        mJafDao = jafDao;
    }

    //region SpecificationLocalRepository
    @NonNull
    @Override
    public List<SpecificationData> getAllSpecification() {
        return mJafDao.getAllSpecification();
    }
    //endregion
}