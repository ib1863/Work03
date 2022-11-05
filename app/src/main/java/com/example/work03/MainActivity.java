package com.example.work03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton tb1;
    EditText et1, et2;
    Button btn;
    boolean checkNum, checkMul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb1 = (ToggleButton) findViewById(R.id.toggleButton);
        et1 = (EditText) findViewById(R.id.editTextNumberDecimal);
        et2 = (EditText) findViewById(R.id.editTextNumberDecimal2);
        btn = (Button) findViewById(R.id.button);
    }

    public static boolean isNumeric(String toCheck)
    {
        try{ //checking if in the command below theres a problem, like turning a / or .. to double number
            Double.parseDouble(toCheck);
            return true;
        } catch (NumberFormatException e) { // if the try found a problem he will come to here and return false
            return false;
        }
    }


    public void SeeSeries(View view) {
        String firstNum = et1.getText().toString();
        String mul = et2.getText().toString();
        checkNum = isNumeric(firstNum);
        checkMul = isNumeric(mul);
        if(checkNum == false || checkMul == false)
        {
            Toast.makeText(this, "Wrong Input!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent si = new Intent(this, Series.class);
            si.putExtra("firstNum", firstNum);
            si.putExtra("mul", mul);
            if(tb1.isChecked() == true)
            {
                si.putExtra("Series", 1);
                startActivity(si);
            }
            else
            {
                si.putExtra("Series", 0); //0 for geometrical, 1 for mathematical
                startActivity(si);
            }


        }
    }
}