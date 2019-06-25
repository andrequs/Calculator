package com.example.admin.nyproject.data.local.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.admin.nyproject.data.model.SpecificationData;

import java.util.List;

@Dao
public interface JafDao {

    @Query("SELECT * FROM Specification")
    List<SpecificationData> getAllSpecification();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSpecification(SpecificationData data);

    @Query("DELETE FROM Specification")
    void deleteAllSpecificationData();
}
