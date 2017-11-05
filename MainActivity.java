package com.example.jenniferhott_leitsch.jhott_leitsch_tipcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double five = .05;
    double ten = .10;
    double fiveteen = .15;
    double twenty = .20;
    double twentyfive = .25;
    double tipAmount;
    double initalBill;
    double totalBill;
    String tipChoice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText amount = findViewById(R.id.EnterBillAmount);
        final Spinner group = findViewById(R.id.tipSpinner);
        Button tipCalc = findViewById(R.id.CalculateTip);
            tipCalc.setOnClickListener(new View.OnClickListener() {
                final TextView result = findViewById(R.id.TipResult);
                @Override
                public void onClick(View view) {
                    initalBill = Double.parseDouble(amount.getText().toString());
                    DecimalFormat currency =  new DecimalFormat("$###,###.00");
                    tipChoice = group.getSelectedItem().toString();
                    switch (tipChoice){
                        case "Tip of 5%":
                            tipAmount = initalBill * five;
                            break;
                        case "Tip of 10%":
                            tipAmount = initalBill * ten;
                            break;
                        case "Tip of 15%":
                            tipAmount = initalBill * fiveteen;
                            break;
                        case "Tip of 20%":
                            tipAmount = initalBill * twenty;
                            break;
                        case "Tip of 25%":
                            tipAmount = initalBill * twentyfive;
                            break;
                        default:
                            tipAmount = 0;
                            break;
                    }
                    totalBill = initalBill + tipAmount;
                    result.setText("Your inital bill is: " + currency.format(initalBill) + " plus a " + tipChoice +
                            " means your tip will be " + currency.format(tipAmount) +
                    ". Your total bill will be " + currency.format(totalBill) + ".");
                }
            });
    }
}
