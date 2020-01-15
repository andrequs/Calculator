package com.example.admin.nyproject.ui.main;

import android.support.annotation.NonNull;




import java.io.IOException;


public interface MainContract {
    interface View {

        void addWidth(int width) throws IOException;

        void showWrongWidthError();

        void setResultOfCalculation(@NonNull String result);

        void showEmptyLengthError();

        void showEmptyThicknessError();

        void showQuantityOfBoards(@NonNull String quantity);

        void showEmptyBoardListError();

        void showBoardsList(@NonNull String list);

        void restoreData();
    }

    interface Presenter {

        void calculate(@NonNull String width, String length, String thickness) throws IOException;

        void handleWidth(@NonNull String width);

        void addToBoardArray(float width, float length, float thickness);

        void calcBoardsList();

        void deleteFromBoardsArray();

        void getBoardsWidthList();

        void restoreData();
    }
}
