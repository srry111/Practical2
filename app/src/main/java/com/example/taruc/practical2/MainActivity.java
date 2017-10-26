package com.example.taruc.practical2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editWeight;
    private EditText editHeight;
    private TextView textBMI;
    private Button   calculate;
    private Button  reset;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editWeight = (EditText)findViewById(R.id.editTextWeight);
        editHeight = (EditText)findViewById(R.id.editTextHeight);
        textBMI = (TextView)findViewById(R.id.textViewResults);
        calculate = (Button)findViewById(R.id.buttonCalculate);
        reset = (Button)findViewById(R.id.buttonReset);
        imageView = (ImageView)findViewById(R.id.imageViewResult);


    }


    public void calculateBMI(View view){
        double height = Double.parseDouble(editHeight.getText().toString())/100;
        double weight = Double.parseDouble(editWeight.getText().toString());

        double bmi = weight/Math.pow(height,2);

        displayBMI(bmi);

    }

    public void resetButton(View view){
        editWeight.setText("");
        editHeight.setText("");
        textBMI.setText("BMI: #");
        imageView.setImageResource(R.drawable.empty);


    }

    public void displayBMI(double bmi){
        String bmiText = "";
        String resultText;

        if(bmi <= 18.5){
            bmiText = "Under";
            imageView.setImageResource(R.drawable.under);
        }
        else if(bmi >18.5 && bmi <= 24.9)
        {
            bmiText = "Normal";
            imageView.setImageResource(R.drawable.normal);

        }
        else if(bmi >= 25){
            bmiText = "Over";
            imageView.setImageResource(R.drawable.over);
        }
        resultText = "BMI: " + String.format("%.2f",bmi) + bmiText;
        textBMI.setText(resultText);

    }



}
