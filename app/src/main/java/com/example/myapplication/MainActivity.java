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
        case "Inch":
            switch (toUnit) {
                case "Foot":
                    result = value / 12;
                    break;
                case "Yard":
                    result = value / 36;
                    break;
                case "Mile":
                    result = value / 63360;
                    break;
                case "Centimeter":
                    result = value * 2.54;
                    break;
                case "Kilometer":
                    result = value / 39370;
                    break;
                default:
                    result = value;
            }
            break;
        case "Foot":
            switch (toUnit) {
                case "Inch":
                    result = value * 12;
                    break;
                case "Yard":
                    result = value / 3;
                    break;
                case "Mile":
                    result = value / 5280;
                    break;
                case "Centimeter":
                    result = value * 30.48;
                    break;
                case "Kilometer":
                    result = value / 3281;
                    break;
                default:
                    result = value;
            }
            break;
        case "Yard":
            switch (toUnit) {
                case "Inch":
                    result = value * 36;
                    break;
                case "Foot":
                    result = value * 3;
                    break;
                case "Mile":
                    result = value / 1760;
                    break;
                case "Centimeter":
                    result = value * 91.44;
                    break;
                case "Kilometer":
                    result = value / 1094;
                    break;
                default:
                    result = value;
            }
            break;
        case "Mile":
            switch (toUnit) {
                case "Inch":
                    result = value * 63360;
                    break;
                case "Foot":
                    result = value * 5280;
                    break;
                case "Yard":
                    result = value * 1760;
                    break;
                case "Centimeter":
                    result = value * 160934;
                    break;
                case "Kilometer":
                    result = value * 1.60934;
                    break;
                default:
                    result = value;
            }
            break;
        case "Centimeter":
            switch (toUnit) {
                case "Inch":
                    result = value / 2.54;
                    break;
                case "Foot":
                    result = value / 30.48;
                    break;
                case "Yard":
                    result = value / 91.44;
                    break;
                case "Mile":
                    result = value / 160934;
                    break;
                case "Kilometer":
                    result = value / 100000;
                    break;
                default:
                    result = value;
            }
            break;
        case "Kilometer":
            switch (toUnit) {
                case "Inch":
                    result = value * 39370;
                    break;
                case "Foot":
                    result = value * 3281;
                    break;
                case "Yard":
                    result = value * 1094;
                    break;
                case "Mile":
                    result = value / 1.60934;
                    break;
                case "Centimeter":
                    result = value * 100000;
                    break;
                default:
                    result = value;
            }
            break;
        case "Pound":
            switch (toUnit) {
                case "Ounce":
                    result = value * 16;
                    break;
                case "Ton":
                    result = value / 2000;
                    break;
                case "Kilogram":
                    result = value / 2.20462;
                    break;
                case "Gram":
                    result = value * 453.592;
                    break;
                default:
                    result = value;
            }
            break;
        case "Ounce":
            switch (toUnit) {
                case "Pound":
                    result = value / 16;
                    break;
                case "Ton":
                    result = value / 32000;
                    break;
                case "Kilogram":
                    result = value / 35.274;
                    break;
                case "Gram":
                    result = value * 28.3495;
                    break;
                default:
                    result = value;
            }
            break;
        case "Ton":
            switch (toUnit) {
                case "Pound":
                    result = value * 2000;
                    break;
                case "Ounce":
                    result = value * 32000;
                    break;
                case "Kilogram":
                    result = value * 907.185;
                    break;
                case "Gram":
                    result = value * 907185;
                    break;
                default:
                    result = value;
            }
            break;
        case "Kilogram":
            switch (toUnit) {
                case "Pound":
                    result = value * 2.20462;
                    break;
                case "Ounce":
                    result = value * 35.274;
                    break;
                case "Ton":
                    result = value / 907.185;
                    break;
                case "Gram":
                    result = value * 1000;
                    break;
                default:
                    result = value;
            }
            break;
        case "Gram":
            switch (toUnit) {
                case "Pound":
                    result = value / 453.592;
                    break;
                case "Ounce":
                    result = value / 28.3495;
                    break;
                case "Ton":
                    result = value / 907185;
                    break;
                case "Kilogram":
                    result = value / 1000;
                    break;
                default:
                    result = value;
            }
            break;
        case "Celsius":
            switch (toUnit) {
                case "Fahrenheit":
                    result = (value * 1.8) + 32;
                    break;
                case "Kelvin":
                    result = value + 273.15;
                    break;
                default:
                    result = value;
            }
            break;
        case "Fahrenheit":
            switch (toUnit) {
                case "Celsius":
                    result = (value - 32) / 1.8;
                    break;
                case "Kelvin":
                    result = ((value - 32) / 1.8) + 273.15;
                    break;
                default:
                    result = value;
            }
            break;
        case "Kelvin":
            switch (toUnit) {
                case "Celsius":
                    result = value - 273.15;
                    break;
                case "Fahrenheit":
                    result = ((value - 273.15) * 1.8) + 32;
                    break;
                default:
                    result = value;
            }
            break;
    }

    textViewResult.setText(String.format("%.2f", result) + " " + toUnit);
}
}
