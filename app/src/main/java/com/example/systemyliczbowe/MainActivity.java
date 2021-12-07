package com.example.systemyliczbowe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.systemyliczbowe.NumberConverter.ConversionToBin;
import com.example.systemyliczbowe.NumberConverter.ConversionToHex;
import com.example.systemyliczbowe.NumberConverter.ConversionToOct;
import com.example.systemyliczbowe.NumberConverter.Converter;
import com.example.systemyliczbowe.kalkulator.Calculator;
import com.example.systemyliczbowe.kalkulator.OperationAdd;
import com.example.systemyliczbowe.kalkulator.OperationDivide;
import com.example.systemyliczbowe.kalkulator.OperationMultiply;
import com.example.systemyliczbowe.kalkulator.OperationSubtract;

public class MainActivity extends AppCompatActivity {

    Converter converter = new Converter();
    TextView conversionResultTextView;
    EditText conversionInput;

    Calculator calculator = new Calculator();
    String operation;
    TextView textViewL1, textViewL2;
    TextView result;
    TextView textViewOperation;
    double l1, l2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conversionResultTextView = findViewById(R.id.textViewRes);
        conversionInput = (EditText) findViewById(R.id.editTextInput);
        textViewOperation = findViewById(R.id.textViewOperation);
        textViewL1 = findViewById(R.id.firstNum);
        textViewL2 = findViewById(R.id.secondNum);
        result = findViewById(R.id.calcRes);
    }

    public void convertNumber(View view) {
        int radioId = ((RadioGroup) findViewById(R.id.radioGroup)).getCheckedRadioButtonId();
        String system = ((RadioButton) findViewById(radioId)).getText().toString();
        Long number = Long.parseLong(conversionInput.getText().toString());
        switch (system) {
            case "2":
                converter.setConversionAlgorithm(new ConversionToBin());
                break;
            case "8":
                converter.setConversionAlgorithm(new ConversionToOct());
                break;
            case "16":
                converter.setConversionAlgorithm(new ConversionToHex());
                break;
        }
        conversionResultTextView.setText(converter.convert(number));
    }

    public void changeOperation(View view) {
        this.operation = ((Button) view).getText().toString();
        textViewOperation.setText(this.operation);
    }

    public void changeNumber(View view) {
        String numberStr = ((Button) view).getText().toString();
        if (operation == null) {
            textViewL1.setText(textViewL1.getText().toString() + numberStr);
        } else {
            textViewL2.setText(textViewL2.getText().toString() + numberStr);
        }
    }

    public void evaluateResult(View view) {
        l1 = Double.parseDouble(textViewL1.getText().toString());
        l2 = Double.parseDouble(textViewL2.getText().toString());
        switch (operation) {
            case "+":
                calculator.setOperation(new OperationAdd());
                break;
            case "-":
                calculator.setOperation(new OperationSubtract());
                break;
            case "/":
                calculator.setOperation(new OperationDivide());
                break;
            case "*":
                calculator.setOperation(new OperationMultiply());
                break;
        }
        result.setText(String.valueOf(calculator.execute(l1, l2)));
        clearNumberTextViews();
        resetFields();
    }

    public void clearNumberTextViews() {
        textViewL1.setText("");
        textViewL2.setText("");
        textViewOperation.setText("");
    }

    public void resetFields() {
        this.operation = null;
        
    }
}