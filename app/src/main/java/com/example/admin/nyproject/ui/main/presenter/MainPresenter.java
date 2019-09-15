package com.example.admin.nyproject.ui.main.presenter;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.example.admin.nyproject.data.model.Board;
import com.example.admin.nyproject.ui.main.MainContract;

import java.util.ArrayList;

public class MainPresenter implements MainContract.Presenter {
    private static final int MAX_LENGTH_OF_WIDTH = 2;
    private ArrayList <Board> boardsList = new ArrayList<>();
    private float result;
    @NonNull
    private MainContract.View mView;

    public MainPresenter(@NonNull MainContract.View view) {
        mView = view;
    }

    //region MainContract.Presenter
    @Override
    public void calculate(@NonNull String width, String length, String thickness) {
        if (TextUtils.isEmpty(length)) {
            mView.showEmptyLengthError();
            return;
        }

        if (TextUtils.isEmpty(thickness)) {
            mView.showEmptyThicknessError();
            return;
        }

        try {

            float lengthFloat = Float.parseFloat(length);
            float thicknessFloat = Float.parseFloat(thickness);
            float widthFloat = Float.parseFloat(width);
            addToBoardArray(widthFloat,lengthFloat,thicknessFloat);
            calcBoardsList();
            mView.setResultOfCalculation(String.valueOf(result));
            mView.showQuantityOfBoards(String.valueOf(boardsList.size()));
        } catch (NumberFormatException ignored) {
            mView.showWrongWidthError();
        }
        getBoardsWidthList();
    }

    @Override
    public void handleWidth(@NonNull String width) {
        try {
            if (width.trim().length() == MAX_LENGTH_OF_WIDTH) {
                int value = Integer.parseInt(width);
                mView.addWidth(value);
            }
        } catch (NumberFormatException e) {
            mView.showWrongWidthError();
        }
    }

    @Override
    public void addToBoardArray(float width, float length, float thickness) {
        Board board = new Board(width, length,thickness);
        boardsList.add(board);
    }

    @Override
    public void calcBoardsList() {
        float sum = 0;
        if(boardsList.size() > 0){
            for (int i = 0; boardsList.size() > i; i++ ){
                sum = sum + boardsList.get(i).
                        boardSum(
                                boardsList.get(i).getWidth(),
                                boardsList.get(i).getLenth(),
                                boardsList.get(i).getThickess());

            }
        }
        result = sum;
    }

    @Override
    public void deleteFromBoardsArray() {
        if(boardsList.size() < 1){
            mView.showQuantityOfBoards("");
            mView.setResultOfCalculation("");
            mView.showEmptyBoardListError();
        }else {
            result = 0;
            int size = boardsList.size() - 1;
            boardsList.remove(size);
            calcBoardsList();
            mView.setResultOfCalculation(String.valueOf(result));
            mView.showQuantityOfBoards(String.valueOf(boardsList.size()));
            getBoardsWidthList();
        }
        if(boardsList.size() < 1){
            mView.showQuantityOfBoards("");
            mView.setResultOfCalculation("");
            mView.showEmptyBoardListError();
        }
    }

    @Override
    public void getBoardsWidthList() {
        String list = "";
        for(int i = 0; boardsList.size() > i; i++){
            list = list.concat(String.valueOf(boardsList.get(i).getWidth())).concat("|");
        }
        mView.showBoardsList(list);


    }

    //endregion
}
