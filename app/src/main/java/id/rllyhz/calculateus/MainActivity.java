package id.rllyhz.calculateus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnNumberZero, btnNumberOne, btnNumberTwo, btnNumberThree, btnNumberFour, btnNumberFive,
            btnNumberSix, btnNumberSeven, btnNumberEight, btnNumberNine,

            btnAC, btnC, btnLeftBracket, btnRightBracket,
            btnSin, btnCos, btnTan, btnLog, btnLn,
            btnSquareRoot, btnSquare, btnFactorial, btnInverse,
            btnPI, btnPeriod, btnDivision, btnMultiplication, btnAddition, btnSubtraction, btnEqual;

    private TextView tvMainPreview, tvSecondPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setClickEventToAllButtons();
        setMainPreviewText("0");
        setSecondPreviewText("");
    }

    private void initViews() {
        btnNumberZero = findViewById(R.id.btnNumberZero);
        btnNumberOne = findViewById(R.id.btnNumberOne);
        btnNumberTwo = findViewById(R.id.btnNumberTwo);
        btnNumberThree = findViewById(R.id.btnNumberThree);
        btnNumberFour = findViewById(R.id.btnNumberFour);
        btnNumberFive = findViewById(R.id.btnNumberFive);
        btnNumberSix = findViewById(R.id.btnNumberSix);
        btnNumberSeven = findViewById(R.id.btnNumberSeven);
        btnNumberEight = findViewById(R.id.btnNumberEight);
        btnNumberNine = findViewById(R.id.btnNumberNine);
        btnAC = findViewById(R.id.btnAC);
        btnC = findViewById(R.id.btnC);
        btnLeftBracket = findViewById(R.id.btnLeftBracket);
        btnRightBracket = findViewById(R.id.btnRightBracket);
        btnSin = findViewById(R.id.btnSin);
        btnCos = findViewById(R.id.btnCos);
        btnTan = findViewById(R.id.btnTan);
        btnLog = findViewById(R.id.btnLog);
        btnLn = findViewById(R.id.btnLn);
        btnSquare = findViewById(R.id.btnSquare);
        btnSquareRoot = findViewById(R.id.btnSquareRoot);
        btnFactorial = findViewById(R.id.btnFactorial);
        btnInverse = findViewById(R.id.btnInverse);
        btnPI = findViewById(R.id.btnPI);
        btnPeriod = findViewById(R.id.btnPeriod);
        btnDivision = findViewById(R.id.btnDivision);
        btnMultiplication = findViewById(R.id.btnMultiplication);
        btnAddition = findViewById(R.id.btnAddition);
        btnSubtraction = findViewById(R.id.btnSubtraction);
        btnEqual = findViewById(R.id.btnEqual);

        tvMainPreview = findViewById(R.id.tvMainPreview);
        tvSecondPreview = findViewById(R.id.tvSecondPreview);
    }

    private void setClickEventToAllButtons() {
        btnNumberZero.setOnClickListener(this);
        btnNumberOne.setOnClickListener(this);
        btnNumberTwo.setOnClickListener(this);
        btnNumberThree.setOnClickListener(this);
        btnNumberFour.setOnClickListener(this);
        btnNumberFive.setOnClickListener(this);
        btnNumberSix.setOnClickListener(this);
        btnNumberSeven.setOnClickListener(this);
        btnNumberEight.setOnClickListener(this);
        btnNumberNine.setOnClickListener(this);
        btnAC.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnLeftBracket.setOnClickListener(this);
        btnRightBracket.setOnClickListener(this);
        btnSin.setOnClickListener(this);
        btnCos.setOnClickListener(this);
        btnTan.setOnClickListener(this);
        btnLog.setOnClickListener(this);
        btnLn.setOnClickListener(this);
        btnSquare.setOnClickListener(this);
        btnSquareRoot.setOnClickListener(this);
        btnFactorial.setOnClickListener(this);
        btnInverse.setOnClickListener(this);
        btnPI.setOnClickListener(this);
        btnPeriod.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnMultiplication.setOnClickListener(this);
        btnAddition.setOnClickListener(this);
        btnSubtraction.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
    }

    private void setMainPreviewText(String text) {
        tvMainPreview.setText(text);
    }

    private String getMainPreviewText() {
        return tvMainPreview.getText().toString().isEmpty()? "0" : tvMainPreview.getText().toString();
    }

    private void setSecondPreviewText(String text) {
        tvSecondPreview.setText(text);
    }

    private String getSecondPreviewText() {
        return tvSecondPreview.getText().toString().isEmpty() ? "0" : tvSecondPreview.getText().toString();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnNumberZero:
                appendNumber("0");
                break;

            case R.id.btnNumberOne:
                appendNumber("1");
                break;

            case R.id.btnNumberTwo:
                appendNumber("2");
                break;

            case R.id.btnNumberThree:
                appendNumber("3");
                break;

            case R.id.btnNumberFour:
                appendNumber("4");
                break;

            case R.id.btnNumberFive:
                appendNumber("5");
                break;

            case R.id.btnNumberSix:
                appendNumber("6");
                break;

            case R.id.btnNumberSeven:
                appendNumber("7");
                break;

            case R.id.btnNumberEight:
                appendNumber("8");
                break;

            case R.id.btnNumberNine:
                appendNumber("9");
                break;

            case R.id.btnAC:
                clearAll();
                break;

            case R.id.btnC:
                clearLastNumber();
                break;

            case R.id.btnLeftBracket:
                break;

            case R.id.btnRightBracket:
                break;

            case R.id.btnSin:
                break;

            case R.id.btnCos:
                break;

            case R.id.btnTan:
                break;

            case R.id.btnLn:
                break;

            case R.id.btnSquare:
                break;

            case R.id.btnSquareRoot:
                break;

            case R.id.btnFactorial:
                break;

            case R.id.btnInverse:
                break;

            case R.id.btnPI:
                break;

            case R.id.btnPeriod:

                break;

            case R.id.btnDivision:
                break;

            case R.id.btnMultiplication:
                break;

            case R.id.btnAddition:
                break;

            case R.id.btnSubtraction:
                break;

            case R.id.btnEqual:
                break;

        }
    }


    /*
    * Helper Methods
    * */

    private void appendNumber(String number) {
        if (getMainPreviewText().isEmpty() || getMainPreviewText().equals("0")) {
            setMainPreviewText(number);
            return;
        }

        String newNumber = getMainPreviewText();
        newNumber = newNumber + number;
        setMainPreviewText(newNumber);
    }

    private void clearAll() {
        setMainPreviewText("0");
        setSecondPreviewText("");
    }

    private void clearLastNumber() {
        if (getMainPreviewText().isEmpty()) return;

        String val = getMainPreviewText();
        val = val.substring(0, val.length() - 1);
        setMainPreviewText(val);
    }

    private int factorialOf(int number) {
        return (number == 0 || number == 1) ? 1 : (number * factorialOf(number -1));
    }

    private int convertStringToint(String number) {
        return  Integer.parseInt(number);
    }

    private double convertStringToDouble(String number) {
        return Double.parseDouble(number);
    }

    private String convertIntegerToString(int number) {
        return String.valueOf(number);
    }

    private String convertDoubleToString(double number) {
        return String.valueOf(number);
    }

    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}