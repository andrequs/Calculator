package com.example.admin.nyproject;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;


public class SaveActivity extends AppCompatActivity {

    EditText packageNum;
    EditText packageGrade;
    EditText packageQuntity;
    EditText packageM3SaveActivity;
    DataBaseHelper myHelper;
    ListView listViewDb;
    String m3;
    String qunt;
    String nums;
    String grades;
    String quantitys;
    String m3ms;
    static final String DATABASE_CAT = "databases";
    static final String DATABASE_NAME = "boards.db";
    ArrayList<String> arrDb;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        listViewDb = findViewById(R.id.listView);
        packageNum = findViewById(R.id.etNum);
        packageGrade = findViewById(R.id.etGrade);
        packageQuntity = findViewById(R.id.etQuantity);
        packageM3SaveActivity = findViewById(R.id.etM3);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        m3 = bundle.getString("DATA_M3");
        qunt = bundle.getString("DATA_QUNT");
        packageQuntity.setText(qunt);
        packageM3SaveActivity.setText(m3);
        String filePath = databasePath();
        myHelper = new DataBaseHelper(this, filePath, null, 1);

    }


    public void onClickWrite(View view) {
        nums = packageNum.getText().toString();
        grades = packageGrade.getText().toString();
        quantitys = packageQuntity.getText().toString();
        m3ms = packageM3SaveActivity.getText().toString();
        if (nums.length() < 1 || nums.equals(" ") && grades.length() < 1 && quantitys.length() < 1 && m3ms.length() < 1) {
            Toast.makeText(this, "Заповніть дані запису!", Toast.LENGTH_SHORT).show();

        } else {
            boolean isInserted = myHelper.insertData(nums, grades, quantitys, m3ms);

            if (isInserted == true) {
                Toast.makeText(this, "Записано", Toast.LENGTH_SHORT).show();
                clearRows();
            } else
                Toast.makeText(this, "Помилка: Дані не записані!", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickShowDb(View v) {
        returnListOfItems();


    }

    public void onClickDeleteSave(View v) {
        EditText etNum = findViewById(R.id.etNum);
        Integer deleteRows = myHelper.deleteData(etNum.getText().toString());
        if (deleteRows > 0) {
            Toast.makeText(this, "Data Deleted!", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, "Data did'nt exist!", Toast.LENGTH_SHORT).show();


    }

    public void onClickSum(View v) {

    }


    ///////////////////// Службові методи//////////////////

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }


    static String databasePath() {
        String sdCard = Environment.getExternalStorageDirectory().getPath();
        String fileCat = sdCard + "/" + DATABASE_CAT;
        File dir = new File(fileCat);
        if (!dir.exists())
            dir.mkdir();
        String filePath = fileCat + "/" + DATABASE_NAME;
        return filePath;
    }

    void clearRows() {
        EditText etNum = findViewById(R.id.etNum);
        EditText etGrade = findViewById(R.id.etGrade);
        EditText etQunt = findViewById(R.id.etQuantity);
        EditText etM3 = findViewById(R.id.etM3);
        etNum.setText("");
        etGrade.setText("");
        etQunt.setText("");
        etM3.setText("");
    }

    public void returnListOfItems() {
        arrDb = new ArrayList<>();
        Cursor res = myHelper.getAllData();
        arrDb.add("Number |   Grade |    Quantity  |   m3 \n");
        if (res.getCount() == 0) {
            showMessage("Помилка", "Дані відсутні!");
        } else {
            StringBuilder buf = new StringBuilder();
            while (res.moveToNext()) {
                buf.append("    #" + res.getString(0) + "    |    ");
                buf.append(res.getString(1) + "   |   ");
                buf.append(res.getString(2) + "шт  " + "   |  ");
                buf.append(res.getString(3) + "m3" + "\n\n");

            }
            arrDb.add(buf.toString());
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrDb) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    TextView text = view.findViewById(android.R.id.text1);
                    text.setTextColor(Color.BLACK);
                    return view;
                }

            };

            listViewDb.setAdapter(adapter);

            myHelper.close();
        }
    }

}

