package com.example.admin.nyproject.data.local.specification;

import android.support.annotation.NonNull;

import com.example.admin.nyproject.data.model.SpecificationData;

import java.util.List;

public interface SpecificationLocalRepository {
    @NonNull
    List<SpecificationData> getAllSpecification();
}