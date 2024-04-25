package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerFrom, spinnerTo;
    private EditText editTextValue;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerFrom = findViewById(R.id.spinnerFrom);
        spinnerTo = findViewById(R.id.spinnerTo);
        editTextValue = findViewById(R.id.editTextValue);
        textViewResult = findViewById(R.id.textViewResult);

        ArrayAdapter<CharSequence> adapterLength = ArrayAdapter.createFromResource(
                this,
                R.array.length_units,
                android.R.layout.simple_spinner_item
        );
        adapterLength.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapterWeight = ArrayAdapter.createFromResource(
                this,
                R.array.weight_units,
                android.R.layout.simple_spinner_item
        );
        adapterWeight.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapterTemperature = ArrayAdapter.createFromResource(
                this,
                R.array.temperature_units,
                android.R.layout.simple_spinner_item
        );
        adapterTemperature.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerFrom.setAdapter(adapterLength);
        spinnerTo.setAdapter(adapterLength);

        Button buttonConvert = findViewById(R.id.buttonConvert);
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertUnits();
            }
        });

        spinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedUnit = parent.getItemAtPosition(position).toString();
                switch (selectedUnit) {
                    case "Inch":
                    case "Foot":
                    case "Yard":
                    case "Mile":
                    case "Centimeter":
                    case "Kilometer":
                        spinnerTo.setAdapter(adapterLength);
                        break;
                    case "Pound":
                    case "Ounce":
                    case "Ton":
                    case "Kilogram":
                    case "Gram":
                        spinnerTo.setAdapter(adapterWeight);
                        break;
                    case "Celsius":
                    case "Fahrenheit":
                    case "Kelvin":
                        spinnerTo.setAdapter(adapterTemperature);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void convertUnits() {
        String fromUnit = spinnerFrom.getSelectedItem().toString();
        String toUnit = spinnerTo.getSelectedItem().toString();
        double value = Double.parseDouble(editTextValue.getText().toString());
        double result = 0;

        switch (fromUnit) {
            // 在这里实现不同单位的转换逻辑,例如:
            case "Inch":
                if (toUnit.equals("Centimeter")) {
                    result = value * 2.54;
                }
                // 处理其他目标单位...
                break;
            // 处理其他源单位...
        }

        textViewResult.setText(String.format("%.2f", result) + " " + toUnit);
    }
}