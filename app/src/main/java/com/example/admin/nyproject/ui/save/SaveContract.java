package com.example.admin.nyproject.ui.save;

import android.support.annotation.NonNull;

import com.example.admin.nyproject.data.model.SpecificationData;

import java.util.List;

public interface SaveContract {
    interface View {
        void showSpecificationData(@NonNull List<SpecificationData> specificationData);
    }

    interface Presenter {
        void loadSpecificationData();
    }
}
