package com.example.admin.nyproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    EditText widthEditText;
    EditText thicknessEditText;
    EditText lengthEditText;
    TextView sumOfWidthTextView;
    TextView quantityView;
    ArrayList<Integer> spec;
    ArrayList<Integer> calcArr;
    ArrayList<Float> lenArr;
    TextView calcView;
    TextView widthArrayTextView;
    int widToInt;

    float lenPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spec = new ArrayList<>();
        calcArr = new ArrayList<>();
        lenArr = new ArrayList<>();
        lengthEditText = findViewById(R.id.lengthEditText);
        sumOfWidthTextView = findViewById(R.id.sumOfWidthTextView);
        widthEditText = findViewById(R.id.widthEditText);
        thicknessEditText = findViewById(R.id.thicknessEditText);
        sumOfWidthTextView = findViewById(R.id.sumOfWidthTextView);
        calcView = findViewById(R.id.calcView);
        quantityView = findViewById(R.id.quantityView);
        widthArrayTextView = findViewById(R.id.widthArrayTextView);



        textWatch(widthEditText);

    }

    public void Onclick_delete(View v) {
        int r = calcArr.size();
        int n = spec.size();
        int l = lenArr.size();
        int res;

        if (n == 0) {
            showToast(this.getString(R.string.txtErrorEmptyFields));
            sumOfWidthTextView.setText("");
        } else if (l == 0) {
            showToast(this.getString(R.string.txtErrorEmptyFields));
        } else if (n == 1)
            quantityView.setText("");
        if(n > 0)
            spec.remove(n - 1);
        if(l > 0)
            lenArr.remove(l - 1);
        int newN = spec.size();
        widthArrayTextView.setText("");
        sumOfWidthTextView.setText("");
        for (int i = 0; i < newN; i++) {
            res = spec.get(i);
            widthArrayTextView.append(res + "|");
            calculate();
            quantityView.setText(String.valueOf(lenArr.size()));

        }

        if (r != 0) {
            calcArr.remove(r - 1);
            calcView.setText("");
            for (int i = 0; i < calcArr.size(); i++)
                calcView.append(calcArr.get(i) + "+");
        }

    }

    public void add() {
        String widthEditText = this.widthEditText.getText().toString();
        String lengthEditText = this.lengthEditText.getText().toString();
        String thickness = thicknessEditText.getText().toString();
        if (widthEditText.equals("")) {
            showToast(this.getString(R.string.txtErrorWid));

        } else if (lengthEditText.equals("")) {
            showToast(this.getString(R.string.txtErrorLen));

        } else if (thickness.equals("")) {
            showToast(this.getString(R.string.txtErrorThickness));

        } else if (widthEditText.length() <= 1) {
            showToast(this.getString(R.string.txtErrorLowWidth));
        } else {
            // TODO: 12.06.2019 Handle NumberFormatException
            widToInt = Integer.parseInt(widthEditText);
            lenPoint = Float.parseFloat(lengthEditText);
            lenArr.add(lenPoint);
            spec.add(widToInt);
            calcArr.add(widToInt);
            this.widthEditText.setText("");
            String sizeStr = String.valueOf(spec.size());
            quantityView.setText(sizeStr);
            calculate();
            showDownMenu();
            showPushDigit();
        }
    }


    public void Onclick_reset(View view) {
        spec.clear();
        calcArr.clear();
        lenArr.clear();
        sumOfWidthTextView.setText("");
        quantityView.setText("");
        widthArrayTextView.setText("");
        calcView.setText("");
    }

    public void OnClick_btnCreate(View v) {
        String m3 = sumOfWidthTextView.getText().toString();
        String qunt = quantityView.getText().toString();
        Intent intent = new Intent(this, SaveActivity.class);
        intent.putExtra("DATA_M3", m3);
        intent.putExtra("DATA_QUNT", qunt);
        startActivity(intent);

    }

    //===========================  Методи       ========================================
    private void calculate() {

        String thickness = thicknessEditText.getText().toString();
        float thiсknessFL = Float.parseFloat(thickness);
        float lenFromArr;
        float sum1 = 0;
        float sum;
        for (int i = 0; i < spec.size(); i++) {
            sum = spec.get(i);
            lenFromArr = lenArr.get(i);
            sum1 = sum1 + (lenFromArr * (sum / 100) * (thiсknessFL / 1000));
        }

        sumOfWidthTextView.setText(/*" м3" + '\n'+ */String.valueOf(sum1));
    }

    private void showPushDigit() {
        int num;
        int j = 0;
        String numStr = "";
        for (int i = 0; i < calcArr.size(); i++) {
            num = calcArr.get(i);
            numStr = numStr + num + "+";
            if (calcArr.size() > 3) {
                calcArr.remove(j);
                calcArr.set(j, calcArr.get(j + 1));
            }
            calcView.setText(numStr);

        }
    }

    private void showDownMenu() {
        int num;
        String numStr = "";
        for (int i = 0; i < spec.size(); i++) {
            num = spec.get(i);
            numStr = numStr + num + "|";
            widthArrayTextView.setText(numStr);

        }
    }

    private void textWatch(EditText etExample) {
        etExample.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 2)
                    add();
            }
        });


    }

    public void showToast(String toast){
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }
}











