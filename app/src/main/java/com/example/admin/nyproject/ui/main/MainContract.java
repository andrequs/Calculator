package com.example.admin.nyproject.ui.main;

import android.support.annotation.NonNull;


import com.example.admin.nyproject.data.model.Board;



public interface MainContract {
    interface View {
        void addWidth(int width);

        void showWrongWidthError();

        void setResultOfCalculation(@NonNull String result);

        void showEmptyLengthError();

        void showEmptyThicknessError();

        void showQuantityOfBoards(@NonNull String quantity);

        void showEmptyBoardListError();
    }

    interface Presenter {
        void calculate(@NonNull String width, String length, String thickness);

        void handleWidth(@NonNull String width);

        void addToBoardArray(float width, float lenth, float thickness);

        void calcBoardsList();

        void deleteFromBoardsArray();



    }
}
