package com.phillippham.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editHeight = findViewById(R.id.edit_height);
        editHeight.setText("0.0");

        final EditText editMass = findViewById(R.id.edit_mass);
        editMass.setText("0.0");

        final EditText displayBMI = findViewById(R.id.display_bmi);
        displayBMI.setFocusable(false);

        Button calculateButton = findViewById(R.id.button_calculate);
        calculateButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.d("BMICalc", "The button has been pressed.");

                double mass = 0.0;
                double height = 0.0;

                if(editHeight.getText().toString().length() > 0 && editMass.getText().toString().length() > 0)
                {
                    mass = Double.parseDouble(editMass.getText().toString());
                    height = Double.parseDouble(editHeight.getText().toString());
                }

                double BMI = 0.0;

                if(mass != 0.0 && height != 0.0)
                {
                    BMI = (mass) / (height * height);
                    displayBMI.setText("BMI is: " + BMI);
                }
                else if(mass == 0.0 || height == 0.0)
                {
                    displayBMI.setText("Decimals > 0.0 only.");
                }
            }
        });
    }
}