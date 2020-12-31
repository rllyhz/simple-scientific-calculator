package id.rllyhz.calculateus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private enum OperationType {
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION
    }

    private Button btnNumberZero, btnNumberOne, btnNumberTwo, btnNumberThree, btnNumberFour, btnNumberFive,
            btnNumberSix, btnNumberSeven, btnNumberEight, btnNumberNine,

    btnAC, btnC, btnPlusMin, btnPercentage,
            btnSin, btnCos, btnTan, btnLog, btnLn,
            btnSquareRoot, btnSquare, btnFactorial, btnInverse,
            btnPI, btnPeriod, btnDivision, btnMultiplication, btnAddition, btnSubtraction, btnEqual;

    private double firstOperand, secondOperand, evaluationResult;
    private OperationType activeOperator;
    private boolean operandsMustEvaluate = false, isFirstOperandActive = true, isSecondOperandActive = false, isAlreadyEvaluated = false;
    private boolean isPeriodActive = false;

    private TextView tvMainPreview, tvSecondPreview, tvActiveOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setClickEventToAllButtons();
        clearAll();
        firstOperandState();
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
        btnPlusMin = findViewById(R.id.btnPlusMin);
        btnPercentage = findViewById(R.id.btnPercentage);
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
        tvActiveOperator = findViewById(R.id.tvActiveOperator);
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
        btnPlusMin.setOnClickListener(this);
        btnPercentage.setOnClickListener(this);
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

    private void setMainPreviewText(String text, boolean prefixWithPeriode) {
        if (!prefixWithPeriode && text.endsWith(".0")) {
            tvMainPreview.setText(text.replace(".0", ""));
        } else {
            tvMainPreview.setText(text);
        }
    }

    private String getMainPreviewText() {
        return tvMainPreview.getText().toString().isEmpty() ? "0" : tvMainPreview.getText().toString();
    }

    private void setSecondPreviewText(String text) {
        if (text.endsWith(".0")) {
            tvSecondPreview.setText(text.replace(".0", ""));
        } else {
            tvSecondPreview.setText(text);
        }
    }

    private String getSecondPreviewText() {
        return tvSecondPreview.getText().toString().isEmpty() ? "0" : tvSecondPreview.getText().toString();
    }

    private void setActiveOperatorPreview(OperationType activeOperator) {
        if (activeOperator == OperationType.ADDITION) {
            tvActiveOperator.setText("+");
        } else if (activeOperator == OperationType.SUBTRACTION) {
            tvActiveOperator.setText("-");
        } else if (activeOperator == OperationType.MULTIPLICATION) {
            tvActiveOperator.setText("×");
        } else if (activeOperator == OperationType.DIVISION) {
            tvActiveOperator.setText("÷");
        } else {
            tvActiveOperator.setText("");
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnNumberZero:
                appendOperandNumber("0");
                break;

            case R.id.btnNumberOne:
                appendOperandNumber("1");
                break;

            case R.id.btnNumberTwo:
                appendOperandNumber("2");
                break;

            case R.id.btnNumberThree:
                appendOperandNumber("3");
                break;

            case R.id.btnNumberFour:
                appendOperandNumber("4");
                break;

            case R.id.btnNumberFive:
                appendOperandNumber("5");
                break;

            case R.id.btnNumberSix:
                appendOperandNumber("6");
                break;

            case R.id.btnNumberSeven:
                appendOperandNumber("7");
                break;

            case R.id.btnNumberEight:
                appendOperandNumber("8");
                break;

            case R.id.btnNumberNine:
                appendOperandNumber("9");
                break;

            case R.id.btnAC:
                clearAll();
                break;

            case R.id.btnC:
                clearLastNumber();
                break;

            case R.id.btnPlusMin:
                if (getMainPreviewText().isEmpty() || getMainPreviewText().equals("") ||
                        getMainPreviewText().equals("0") || isPeriodActive) break;

                double plusMinNum = convertStringToDouble(getMainPreviewText());
                plusMinNum = plusMinNum * -1;

                updateOperands(convertDoubleToString(plusMinNum));
                setMainPreviewText(convertDoubleToString(plusMinNum), false);
                break;

            case R.id.btnPeriod:
                if (getMainPreviewText().isEmpty() || getMainPreviewText().equals("") || getMainPreviewText().contains(".")) break;

                if (isPeriodActive) {
                    isPeriodActive = false;
                    String newNumber = getMainPreviewText();
                    newNumber = newNumber.replace(".", "");
                    setMainPreviewText(newNumber, false);
                } else {
                    isPeriodActive = true;
                    setMainPreviewText(getMainPreviewText() + ".", false);
                }
                break;

            case R.id.btnDivision:
                if (getMainPreviewText().isEmpty() || getMainPreviewText().equals("") || isPeriodActive)
                    break;

                if (getMainPreviewText().equals("0")) {
                    updateOperands("0");
                }

                setOperationType(OperationType.DIVISION);
                break;

            case R.id.btnMultiplication:
                if (getMainPreviewText().isEmpty() || getMainPreviewText().equals("") || isPeriodActive)
                    break;

                if (getMainPreviewText().equals("0")) {
                    updateOperands("0");
                }

                setOperationType(OperationType.MULTIPLICATION);
                break;

            case R.id.btnAddition:
                if (getMainPreviewText().isEmpty() || getMainPreviewText().equals("") || isPeriodActive)
                    break;

                if (getMainPreviewText().equals("0")) {
                    updateOperands("0");
                }

                setOperationType(OperationType.ADDITION);
                break;

            case R.id.btnSubtraction:
                if (getMainPreviewText().isEmpty() || getMainPreviewText().equals("") || isPeriodActive)
                    break;

                if (getMainPreviewText().equals("0")) {
                    updateOperands("0");
                }

                setOperationType(OperationType.SUBTRACTION);
                break;

            case R.id.btnEqual:
                if (getMainPreviewText().isEmpty() || getMainPreviewText().equals("") || isPeriodActive)
                    break;

                if (operandsMustEvaluate) {
                    prosesOperands();
                }
                break;


            case R.id.btnPercentage:
                if (getMainPreviewText().isEmpty() || getMainPreviewText().equals("") || isPeriodActive)
                    break;

                double numToPercentage = convertStringToDouble(getMainPreviewText());
                double percentageResult = numToPercentage / 100;
                updateOperands(convertDoubleToString(percentageResult));
                setMainPreviewText(convertDoubleToString(percentageResult), false);
                break;

            case R.id.btnSin:
                if (getMainPreviewText().isEmpty() || getMainPreviewText().equals("") || isPeriodActive)
                    break;

                double numToSine = convertStringToDouble(getMainPreviewText());
                double sineResult = sin(numToSine);
                updateOperands(convertDoubleToString(sineResult));
                setMainPreviewText(convertDoubleToString(sineResult), false);
                break;

            case R.id.btnCos:
                if (getMainPreviewText().isEmpty() || getMainPreviewText().equals("") || isPeriodActive)
                    break;

                double numToCosine = convertStringToDouble(getMainPreviewText());
                double cosineResult = cos(numToCosine);
                updateOperands(convertDoubleToString(cosineResult));
                setMainPreviewText(convertDoubleToString(cosineResult), false);
                break;

            case R.id.btnTan:
                if (getMainPreviewText().isEmpty() || getMainPreviewText().equals("") || isPeriodActive)
                    break;

                double numToTangent = convertStringToDouble(getMainPreviewText());
                double tangentResult = tan(numToTangent);
                updateOperands(convertDoubleToString(tangentResult));
                setMainPreviewText(convertDoubleToString(tangentResult), false);
                break;

            case R.id.btnLog:
                if (getMainPreviewText().isEmpty() || getMainPreviewText().equals("") || isPeriodActive)
                    break;

                double numToLog = convertStringToDouble(getMainPreviewText());
                double logResult = log(numToLog);
                updateOperands(convertDoubleToString(logResult));
                setMainPreviewText(convertDoubleToString(logResult), false);
                break;

            case R.id.btnLn:
                if (getMainPreviewText().isEmpty() || getMainPreviewText().equals("") || isPeriodActive)
                    break;

                showToast("Hasn't been implemented yet!");

                double numToLn = convertStringToDouble(getMainPreviewText());
                double lnResult = numToLn;
                updateOperands(convertDoubleToString(lnResult));
                setMainPreviewText(convertDoubleToString(lnResult), false);
                break;

            case R.id.btnSquare:
                if (getMainPreviewText().isEmpty() || getMainPreviewText().equals("") || isPeriodActive)
                    break;

                double numToSquare = convertStringToDouble(getMainPreviewText());
                double squareResult = square(numToSquare);
                updateOperands(convertDoubleToString(squareResult));
                setMainPreviewText(convertDoubleToString(squareResult), false);
                break;

            case R.id.btnSquareRoot:
                if (getMainPreviewText().isEmpty() || getMainPreviewText().equals("") || isPeriodActive)
                    break;

                double numToSquareRoot = convertStringToDouble(getMainPreviewText());
                double squareRootResult = squareRoot(numToSquareRoot);
                updateOperands(convertDoubleToString(squareRootResult));
                setMainPreviewText(convertDoubleToString(squareRootResult), false);
                break;

            case R.id.btnFactorial:
                if (getMainPreviewText().isEmpty() || getMainPreviewText().equals("") || isPeriodActive)
                    break;

                int numToFactorial = convertStringToint(getMainPreviewText());
                int factorialResult = factorialOf(numToFactorial);
                updateOperands(convertIntegerToString(factorialResult));
                setMainPreviewText(convertIntegerToString(factorialResult), false);
                break;

            case R.id.btnInverse:
                if (getMainPreviewText().isEmpty() || getMainPreviewText().equals("") || isPeriodActive)
                    break;

                double numToInverse = convertStringToDouble(getMainPreviewText());
                double inverseResult = inverse(numToInverse);
                updateOperands(convertDoubleToString(inverseResult));
                setMainPreviewText(convertDoubleToString(inverseResult), false);
                break;

            case R.id.btnPI:
                if (getMainPreviewText().isEmpty() || getMainPreviewText().equals("") || isPeriodActive)
                    break;

                double numToMultiplyByPI = convertStringToDouble(getMainPreviewText());
                double multiplyByPIResult = multiplyByPI(numToMultiplyByPI);
                updateOperands(convertDoubleToString(multiplyByPIResult));
                setMainPreviewText(convertDoubleToString(multiplyByPIResult), false);
                break;
        }
    }


    /*
     * Helper Methods
     * */

    private void appendOperandNumber(String number) {
        if (getMainPreviewText().isEmpty() || getMainPreviewText().equals("0")) {
            updateOperands(number);
            setMainPreviewText(number, false);
            return;
        }

        String newNumber = getMainPreviewText();

        if (isPeriodActive) {
            double validated = convertStringToDouble(newNumber);
            validated = validated + (convertStringToDouble(number) / 10);
            newNumber = convertDoubleToString(validated);
            setMainPreviewText(newNumber, true);
            isPeriodActive = false;
        } else {
            newNumber = newNumber + number;
            setMainPreviewText(newNumber, false);
        }

        updateOperands(newNumber);
    }

    private void clearAll() {
        setMainPreviewText("0", false);
        setSecondPreviewText("");
        setOperationType(null);
        firstOperandState();
    }

    private void clearLastNumber() {
        String newNumber;

        if (getMainPreviewText().isEmpty() || getMainPreviewText().length() == 1) {
            newNumber = "0";
            setActiveOperatorPreview(null);
        } else {
            String number = getMainPreviewText();
            newNumber = number.substring(0, number.length() - 1);
        }

        updateOperands(newNumber);
        setMainPreviewText(newNumber, false);
    }

    private void updateOperands(String newNumber) {
        if (isFirstOperandActive) {
            firstOperand = convertStringToDouble(newNumber);
        } else if (isSecondOperandActive) {
            secondOperand = convertStringToDouble(newNumber);
        }
    }

    private void setOperationType(OperationType activeOperator) {
        if (activeOperator == null) {
            setActiveOperatorPreview(activeOperator);
            return;
        }

        setSecondPreviewText(convertDoubleToString(firstOperand));
        setMainPreviewText("", false);
        secondOperandState();
        isAlreadyEvaluated = false;

        this.activeOperator = activeOperator;
        setActiveOperatorPreview(activeOperator);
    }

    private void prosesOperands() {
        if (isAlreadyEvaluated) return;

        evaluationResult = evaluateOperands();
        double lastOperand = secondOperand;
        firstOperand = evaluationResult;
        setMainPreviewText(convertDoubleToString(evaluationResult), false);
        setSecondPreviewText(convertDoubleToString(lastOperand));
        isAlreadyEvaluated = true;
        alreadyEvaluatedState();
    }

    private double evaluateOperands() {
        double result;

        if (activeOperator == OperationType.ADDITION) {
            result = firstOperand + secondOperand;
        } else if (activeOperator == OperationType.SUBTRACTION) {
            result = firstOperand - secondOperand;
        } else if (activeOperator == OperationType.MULTIPLICATION) {
            result = firstOperand * secondOperand;
        } else if (activeOperator == OperationType.DIVISION) {
            result = firstOperand / secondOperand;
        } else {
            result = 0d;
        }

        return result;
    }

    private void firstOperandState() {
        operandsMustEvaluate = false;
        isFirstOperandActive = true;
        isSecondOperandActive = false;
        isAlreadyEvaluated = false;
        isPeriodActive = false;
    }

    private void secondOperandState() {
        isFirstOperandActive = false;
        isSecondOperandActive = true;
        operandsMustEvaluate = true;
    }

    private void alreadyEvaluatedState() {
        isFirstOperandActive = true;
        isSecondOperandActive = false;
        operandsMustEvaluate = true;
    }

    private int factorialOf(int number) {
        return (number == 0 || number == 1) ? 1 : (number * factorialOf(number - 1));
    }

    private double square(double number) {
        return number * number;
    }

    private double squareRoot(double number) {
        return Math.sqrt(number);
    }

    private double sin(double number) {
        return Math.sin(number);
    }

    private double cos(double number) {
        return Math.cos(number);
    }

    private double tan(double number) {
        return Math.tan(number);
    }

    private double log(double number) {
        return Math.log(number);
    }

    private double ln(double number) {
        return 0d;
    }

    private double inverse(double number) {
        return 1 / number;
    }

    private double multiplyByPI(double number) {
        return Math.PI * number;
    }

    private int floor(double number) {
        return (int) Math.floor(number);
    }

    private int ceil(double number) {
        return (int) Math.ceil(number);
    }

    private int convertStringToint(String number) {
        return Integer.parseInt(number);
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