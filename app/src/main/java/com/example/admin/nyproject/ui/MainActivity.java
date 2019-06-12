package com.example.admin.nyproject.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.admin.nyproject.R;
import com.example.admin.nyproject.SaveActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    EditText enterTxt2;
    EditText thicknessEnterField;
    EditText enterTxt;
    TextView resultTxt;
    TextView quantityView;
    ArrayList<Integer> spec;
    ArrayList<Integer> calcArr;
    ArrayList<Float> lenArr;
    TextView calcView;
    TextView resultTxt2;
    int widToInt;

    float lenPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spec = new ArrayList<>();
        calcArr = new ArrayList<>();
        lenArr = new ArrayList<>();
        enterTxt = findViewById(R.id.enterTxt);
        resultTxt = findViewById(R.id.resultTxt);
        enterTxt2 = findViewById(R.id.enterTxt2);
        thicknessEnterField = findViewById(R.id.enterTxt3);
        resultTxt = findViewById(R.id.resultTxt);
        calcView = findViewById(R.id.calcView);
        quantityView = findViewById(R.id.quantityView);
        resultTxt2 = findViewById(R.id.resultTxt2);

        textWatch(enterTxt2);

    }

    public void Onclick_delete(View v) {
        int r = calcArr.size();
        int n = spec.size();
        int l = lenArr.size();
        int res;
        if (n == 0) {
            Toast.makeText(this, "Нема що видаляти!", Toast.LENGTH_SHORT).show();
            resultTxt.setText("");

        } else if (l == 0) {
            Toast.makeText(this, "Нема що видаляти!", Toast.LENGTH_SHORT).show();
        } else if (n == 1)
            quantityView.setText("");
        spec.remove(n - 1);


        lenArr.remove(l - 1);
        int newN = spec.size();
        resultTxt2.setText("");
        resultTxt.setText("");
        for (int i = 0; i < newN; i++) {
            res = spec.get(i);
            resultTxt2.append(res + "|");
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

    public void Onclick_add() {
        String wid = enterTxt2.getText().toString();
        String len = enterTxt.getText().toString();
        String thickness = thicknessEnterField.getText().toString();
        if (wid.equals("")) {
            Toast.makeText(this, "Введіть ширину дошки", Toast.LENGTH_LONG).show();

        } else if (len.equals("")) {
            Toast.makeText(this, "Введіть довжину дошки", Toast.LENGTH_LONG).show();

        } else if (thickness.equals("")) {
            Toast.makeText(this, "Введіть товщину дошки", Toast.LENGTH_LONG).show();

        } else if (wid.length() <= 1) {
            Toast.makeText(this, "Занадто вузька дошка!", Toast.LENGTH_SHORT).show();
        } else {
            // TODO: 12.06.2019 Handle NumberFormatException
            widToInt = Integer.parseInt(wid);
            lenPoint = Float.parseFloat(len);
            lenArr.add(lenPoint);
            spec.add(widToInt);
            calcArr.add(widToInt);
            enterTxt2.setText("");
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
        resultTxt.setText("");
        quantityView.setText("");
        resultTxt2.setText("");
        calcView.setText("");
    }

    public void OnClick_btnCreate(View v) {
        String m3 = resultTxt.getText().toString();
        String qunt = quantityView.getText().toString();
        Intent intent = new Intent(this, SaveActivity.class);
        intent.putExtra("DATA_M3", m3);
        intent.putExtra("DATA_QUNT", qunt);
        startActivity(intent);
    }

    //===========================  Методи       ========================================
    private void calculate() {

        String thickness = thicknessEnterField.getText().toString();
        float thiknessFL = Float.parseFloat(thickness);
        String len = enterTxt.getText().toString();
        float lenFromArr;
        float sum1 = 0;
        float sum;
        for (int i = 0; i < spec.size(); i++) {
            sum = spec.get(i);
            lenFromArr = lenArr.get(i);
            sum1 = sum1 + (lenFromArr * (sum / 100) * (thiknessFL / 1000));
        }

        resultTxt.setText(/*" м3" + '\n'+ */String.valueOf(sum1));
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
            resultTxt2.setText(numStr);

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
                    Onclick_add();
            }
        });

    }
}











