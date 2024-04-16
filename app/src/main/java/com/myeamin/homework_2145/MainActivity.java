package com.myeamin.homework_2145;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // UI components
    EditText editTextUnitsConsumed;
    Button buttonCalculate;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the UI components
        editTextUnitsConsumed = findViewById(R.id.editTextUnitsConsumed);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);

        // Set a click listener on the check button
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve the user input as a trimmed string
                String unitsConsumedStr = editTextUnitsConsumed.getText().toString().trim();

                // Check if the input string is empty
                if (unitsConsumedStr.isEmpty()) {
                    // If no input provided, display a request for input
                    textViewResult.setText("Please enter total units consumed.");
                } else {
                    // Parse the input string to an double
                    double unitsConsumed = Double.parseDouble(unitsConsumedStr);

                    // Calculate the electricity bill based on the total units consumed
                    double billAmount;
                    if (unitsConsumed <= 50) {
                        billAmount = unitsConsumed * 0.50; // For first 50 units BDT 0.50/unit
                    } else if (unitsConsumed <= 150) {
                        billAmount = 50 * 0.50 + (unitsConsumed - 50) * 0.75; // For next 100 units BDT 0.75/unit
                    } else if (unitsConsumed <= 250) {
                        billAmount = 50 * 0.50 + 100 * 0.75 + (unitsConsumed - 150) * 1.20; // For next 100 units BDT 1.20/unit
                    } else {
                        billAmount = 50 * 0.50 + 100 * 0.75 + 100 * 1.20 + (unitsConsumed - 250) * 1.50; // For unit above 250 BDT 1.50/unit
                    }

                    // Add 20% surcharge
                    billAmount = billAmount + billAmount * 0.20;

                    // Format the billAmount value with two decimal places
                    String billAmountStr = String.format("%.2f", billAmount);
                    textViewResult.setText("Electricity Bill = BDT " + billAmountStr);
                }
            }
        });


    }
}
