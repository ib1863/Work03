package com.example.work03;

import static com.example.work03.R.layout.support_simple_spinner_dropdown_item;

import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;




public class Series extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lv;
    Button btn;
    TextView  tv1, tv2, tv3, tv4;
    String[] numbers;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series);

        numbers = getArray();
        btn = (Button) findViewById(R.id.button2);
        tv1 = (TextView) findViewById(R.id.textViewX1);
        tv2 = (TextView) findViewById(R.id.textViewd);
        tv3 = (TextView) findViewById(R.id.textViewn);
        tv4 = (TextView) findViewById(R.id.textViewSn);
        lv = (ListView) findViewById(R.id.ListView);
        System.out.println(numbers);
        lv.setOnItemClickListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);


        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, numbers);

         lv.setAdapter(adp);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long l) {

        Double sum = 0., curr = 0.;
        curr = Double.parseDouble(numbers[position]);
        System.out.println(curr);
        Double one = 0., two = 0., three = 0., four = 0.;
        one = Double.parseDouble(numbers[0]);
        two = Double.parseDouble(numbers[1]);
        three = Double.parseDouble(numbers[2]);
        four = Double.parseDouble(numbers[3]);

        if ((four - three) == (two - one))
        {
            tv1.setText(numbers[0]);
            tv2.setText(Double.toString(four-three));
            tv3.setText(Integer.toString(position + 1));
            sum = ((position + 1) * (Double.valueOf(curr) + Double.parseDouble(numbers[0]))) / 2;
            tv4.setText(Double.toString(sum));
        }
        else
        {
            tv1.setText(numbers[0]);
            tv2.setText(Double.toString(two/one));
            tv3.setText(Integer.toString(position + 1));
            double mul = two/one;
            System.out.println(mul);
            sum = ((one * (Math.pow(mul, position+1) - 1)) / (mul-1));
            tv4.setText(Double.toString(sum));
        }

    }

    public String[] getArray()
    {
        NumberFormat numFormat = new DecimalFormat();
        numFormat = new DecimalFormat("0.###E0");
        String arr[] = new String[20];
        double num = 0, first = 0;
        String v;
        Intent gi = getIntent();
        String firstNum = gi.getStringExtra("firstNum");
        String mul = gi.getStringExtra("mul");
        int mOrG = gi.getIntExtra("Series", -1000);
        arr[0] = firstNum;
        first = Double.parseDouble(firstNum);
        if (mOrG == 1) {
            for (int i = 1; i < 20; i++) {
                num = first + (i * Double.valueOf(mul));
                if(num <= 0.000009)
                    arr[i] =  numFormat.format(num);
                else
                    arr[i] = String.format("%.4f" ,num);
            }
            return arr;
        }
        else {
            for (int i = 1; i < 20; i++) {
                num = first * (Math.pow(Double.valueOf(mul), i));
                if(num <= 0.0009 && num > 0 || num >= -0.0009 && num < 0)
                    arr[i] =  numFormat.format(num);
                else
                    arr[i] = String.format("%.4f" ,num);
            }
            return arr;
        }
    }

    public void Return(View view) {
        Intent si = new Intent(this,MainActivity.class);
        startActivity(si);
    }
}