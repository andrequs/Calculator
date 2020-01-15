package com.example.admin.nyproject.ui.main.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.example.admin.nyproject.R;
import com.example.admin.nyproject.core.annotation.LateInit;
import com.example.admin.nyproject.core.ui.BaseFragment;
import com.example.admin.nyproject.ui.MainJafNavigation;
import com.example.admin.nyproject.ui.main.MainContract;
import com.example.admin.nyproject.ui.main.presenter.MainPresenter;
import com.example.admin.nyproject.ui.save.view.SaveFragment;
import com.example.admin.nyproject.utils.watcher.DefaultTextWatcher;
import java.io.IOException;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainFragment extends BaseFragment implements MainContract.View {


    @BindView(R.id.widthEditText)
    EditText mWidthEditText;

    @BindView(R.id.thicknessEditText)
    EditText mThicknessEditText;

    @BindView(R.id.lengthEditText)
    EditText mLengthEditText;

    @BindView(R.id.sumOfWidthTextView)
    TextView mSumOfWidthTextView;

    @BindView(R.id.quantityView)
    TextView mQuantityTextView;

    @BindView(R.id.widthArrayTextView)
    TextView mWidthArrayTextView;

    @LateInit
    private MainContract.Presenter mPresenter;

    @Nullable
    private MainJafNavigation mNavigator;

    @NonNull
    String cubesOfpacket;

    @NonNull
    String quantityOfBoars;



    @NonNull
    private TextWatcher mWidthTextWatcher = new DefaultTextWatcher() {
        @Override
        public void afterTextChanged(@NonNull Editable editable) {
            if (TextUtils.isEmpty(editable.toString())) {
                return;
            }
            mPresenter.handleWidth(editable.toString());
        }
    };

    public static MainFragment newInstance() {

        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);

        return fragment;
    }

    //region Fragment
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() instanceof MainJafNavigation) {
            mNavigator = ((MainJafNavigation) getActivity());
        }

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new MainPresenter(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mWidthEditText.addTextChangedListener(mWidthTextWatcher);
    }

    @Override
    public void onPause() {
        super.onPause();
        mWidthEditText.removeTextChangedListener(mWidthTextWatcher);
    }
    //endregion

    //region BaseFragment
    @LayoutRes
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @NonNull
    @Override
    protected Unbinder bindView(@NonNull View view) {
        return ButterKnife.bind(this, view);
    }

    @Override
    protected void initView() {

    }
    //endregion

    //region Click handlers
    @OnClick(R.id.btnCreate)
    void onCreateButtonClickListener() {
        if (mNavigator != null) {
            mNavigator.showSaveFragment();
            Bundle bundle = new Bundle();
            bundle.putString("cubes", cubesOfpacket );
            bundle.putString("quantity", quantityOfBoars);// set your parameteres

            SaveFragment nextFragment = new SaveFragment();
            nextFragment.setArguments(bundle);

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.framelayout_activity_main_jaf_container, nextFragment).commit();


        }
    }

    @OnClick(R.id.btnRestore)
    void onRestoreButtonClickListener() {
        restoreData();
        showToast("RESTORE");
    }

    @OnClick(R.id.btnDelete)
    void onDeleteButtonClickListener() {
        mPresenter.deleteFromBoardsArray();
        showToast("DELETE");
    }
    //endregion

    //region MainContract.View
    @Override
    public void addWidth(int width) throws IOException {
        mPresenter.calculate(mWidthEditText.getText().toString(),
                mLengthEditText.getText().toString(),
                mThicknessEditText.getText().toString());

    }

    @Override
    public void showWrongWidthError() {
        showToast(R.string.text_main_fragment_wrong_width_format);
    }

    @Override
    public void setResultOfCalculation(@NonNull String result) {
        mWidthEditText.setText(null);
        mSumOfWidthTextView.setText(result);
        cubesOfpacket = result;
    }

    @Override
    public void showEmptyLengthError() {
        showToast("Empty length");
    }

    @Override
    public void showEmptyThicknessError() {
        showToast("Empty Thickness");
    }

    @Override
    public void showQuantityOfBoards(@NonNull String quantity) {
        mQuantityTextView.setText(quantity);
        quantityOfBoars = quantity;
    }

    @Override
    public void showEmptyBoardListError() { showToast("Nothing to delete");

    }

    @Override
    public void showBoardsList(@NonNull String list) {
        mWidthArrayTextView.setText(list);

    }

    @Override
    public void restoreData(){
        mPresenter.restoreData();
    }


    //endregion
}
