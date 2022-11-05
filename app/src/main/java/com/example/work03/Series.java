package com.example.work03;

import static com.example.work03.R.layout.support_simple_spinner_dropdown_item;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Series extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lv;
    TextView tv;
    String[] numbers;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series);

        numbers = getArray();
        tv = (TextView) findViewById(R.id.TextView);
        lv = (ListView) findViewById(R.id.ListView);

        lv.setOnItemClickListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
                support_simple_spinner_dropdown_item,numbers);

        lv.setAdapter(adp);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
        tv.setText(" "+ position);
    }

    public String[] getArray()
    {
        String arr[] = new String[20];
        double num = 0, first = 0;
        Intent gi = getIntent();
        String firstNum = gi.getStringExtra("firstNum");
        String mul = gi.getStringExtra("mul");
        int mOrG = gi.getIntExtra("Series", -1000);
        arr[0] = firstNum;
        first = Double.parseDouble(firstNum);
        if (mOrG == 1) {
            for (int i = 1; i < 20; i++) {
                num = first + (i * Double.valueOf(mul));
                arr[i] = Double.toString(num);
            }
            return arr;
        }
        else {
            for (int i = 1; i < 20; i++) {
                num = first * (Math.pow(Double.valueOf(mul), i));
                arr[i] = Double.toString(num);
            }
            return arr;
        }
    }

}