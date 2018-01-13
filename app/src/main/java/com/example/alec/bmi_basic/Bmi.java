package com.example.alec.bmi_basic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;


public class Bmi extends AppCompatActivity{

    private Button button;
    private EditText fieldheight;
    private EditText fieldweight;
    private TextView result;
    private TextView fieldsuggest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        //Button button = (Button)findViewById(R.id.btnSubmit);
        findViews();
        //button.setOnClickListener(listener);
        setListener();
    }

    private void findViews() {
        button = (Button)findViewById(R.id.btnSubmit);
        fieldheight = (EditText) findViewById(R.id.editTextHeight);
        fieldweight = (EditText) findViewById(R.id.editTextWeight);
        result = (TextView) findViewById(R.id.textViewResult);
        fieldsuggest = (TextView) findViewById(R.id.textViewSuggest);
    }

    private void setListener() {
        button.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            double BMI = calcBMI();
            showResult(BMI);
        }
    };

    private void showResult(double bmi) {
        DecimalFormat nf = new DecimalFormat("0.00");
        //TextView result = (TextView) findViewById(R.id.textViewResult);
        //result.setText("Your BMI is " + nf.format(bmi));
        result.setText(R.string.bmi_result);
        result.append(" " + nf.format(bmi).toString());
        //TextView fieldsuggest = (TextView) findViewById(R.id.textViewSuggest);

        if(bmi >= 35) {
            fieldsuggest.setText(R.string.advice_tooheavy);
        } else if (bmi < 35 & bmi >=30) {
            fieldsuggest.setText(R.string.advice_muchheavy);
        } else if (bmi < 30 & bmi >=24.5) {
            fieldsuggest.setText(R.string.advice_littleheavy);
        } else if (bmi < 18.5) {
            fieldsuggest.setText(R.string.advice_light);
        } else {
            fieldsuggest.setText(R.string.advice_average);
        }
    }

    private double calcBMI() {
//        EditText fieldheight = (EditText) findViewById(R.id.editTextHeight);
//        EditText fieldweight = (EditText) findViewById(R.id.editTextWeight);
        double height = Double.parseDouble(fieldheight.getText()+"") / 100 ;
        double weight = Double.parseDouble(fieldweight.getText()+"");
        double BMI = weight / (height * height);
        return BMI;
    }
}
