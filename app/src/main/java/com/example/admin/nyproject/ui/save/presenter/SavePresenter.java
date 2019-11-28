package com.example.admin.nyproject.ui.save.presenter;

import android.support.annotation.NonNull;

import com.example.admin.nyproject.data.local.db.JafDao;
import com.example.admin.nyproject.data.local.specification.DefaultSpecificationLocalRepository;
import com.example.admin.nyproject.data.local.specification.SpecificationLocalRepository;
import com.example.admin.nyproject.ui.save.SaveContract;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;


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



 }
    //endregion

