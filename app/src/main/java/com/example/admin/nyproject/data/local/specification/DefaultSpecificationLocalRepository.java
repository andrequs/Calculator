package com.example.admin.nyproject.data.local.specification;

import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;

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
    @WorkerThread
    @NonNull
    @Override
    public List<SpecificationData> getAllSpecification() {
        return mJafDao.getAllSpecification();
    }
    //endregion
}