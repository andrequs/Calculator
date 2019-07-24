package com.example.admin.nyproject;

import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.example.admin.nyproject.data.model.Board;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MainFunc extends AppCompatActivity {
    Board board;
    List <Board> boardsList;
    ArrayList<Float> cubeOfBoards = new ArrayList<>();
    EditText lengthEditText = findViewById(R.id.lengthEditText);
    EditText widthEditText = findViewById(R.id.widthEditText);
    EditText thicknessEditText = findViewById(R.id.thicknessEditText);
    float flLength = Float.parseFloat(lengthEditText.getText().toString());
    float flWidth = Float.parseFloat(widthEditText.getText().toString());
    float flThickness = Float.parseFloat(thicknessEditText.getText().toString());


    public void addBoard(){
       board = new Board(flLength, flWidth, flThickness);
       boardsList.add(board);
       cubeOfBoards.add(board.cubesOfBoard());
    }



}
