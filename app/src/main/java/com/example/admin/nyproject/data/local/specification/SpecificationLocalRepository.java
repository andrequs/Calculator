package com.example.admin.nyproject.data.local.specification;

import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;

import com.example.admin.nyproject.data.model.SpecificationData;

import java.util.List;

public interface SpecificationLocalRepository {
    @WorkerThread
    @NonNull
    List<SpecificationData> getAllSpecification();
}