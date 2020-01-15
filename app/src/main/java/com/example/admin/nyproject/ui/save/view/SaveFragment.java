package com.example.admin.nyproject.ui.save.view;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import com.example.admin.nyproject.R;
import com.example.admin.nyproject.core.annotation.LateInit;
import com.example.admin.nyproject.core.ui.BaseFragment;
import com.example.admin.nyproject.data.model.SpecificationData;
import com.example.admin.nyproject.ui.save.SaveContract;
import com.example.admin.nyproject.ui.save.presenter.SavePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class SaveFragment extends BaseFragment implements SaveContract.View {

    @BindView(R.id.etM3)
    EditText etm3;

    @BindView(R.id.etQuantity)
    EditText etQuantity;

    @LateInit
    private SaveContract.Presenter mPresenter;
    String cubes;
    String quantity;



    public static SaveFragment newInstance() {
        Bundle args = new Bundle();
        SaveFragment fragment = new SaveFragment();
        fragment.setArguments(args);
        return fragment;
    }

    //region Fragment
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new SavePresenter(this, mApp.getJafDatabase().jafDao());
        cubes = this.getArguments().getString("cubes");      //get your parameters
        quantity = this.getArguments().getString("quantity");
}


    //endregion

    //region BaseFragment
    @LayoutRes
    @Override
    protected int getLayoutId() {
        return R.layout.activity_save;
    }

    @NonNull
    @Override
    protected Unbinder bindView(@NonNull View view) {
        return ButterKnife.bind(this, view);
    }

    @Override
    protected void initView() {
        etm3.setText(cubes);
        etQuantity.setText(quantity);
        mPresenter.loadSpecificationData();
    }
    //endregion

    //region Click handlers

    @OnClick(R.id.btnWrite)
    void onWriteButtonClickListener() {

        showToast("write");
    }

    @OnClick(R.id.btnShowDb)
    void onShowDbButtonClickListener() {

        showToast("show");
    }

    @OnClick(R.id.btnDelete)
    void onDeleteDbButtonClickListener(){
        showToast("delete");
    }
    //endregion

    //region SaveContract.View
    @Override
    public void showSpecificationData(@NonNull List<SpecificationData> specificationData) {
        // TODO: show data in RecyclerView
    }




    //endregion
}
