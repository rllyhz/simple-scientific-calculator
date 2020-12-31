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

    btnAC, btnC, btnLeftBracket, btnRightBracket,
            btnSin, btnCos, btnTan, btnLog, btnLn,
            btnSquareRoot, btnSquare, btnFactorial, btnInverse,
            btnPI, btnPeriod, btnDivision, btnMultiplication, btnAddition, btnSubtraction, btnEqual;

    private double firstOperand, secondOperand, evaluationResult;
    private OperationType activeOperator;
    private boolean operandsMustEvaluate = false, isFirstOperandActive = true, isSecondOperandActive = false, isAlreadyEvaluated = false;

    private TextView tvMainPreview, tvSecondPreview, tvActiveOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setClickEventToAllButtons();
        setMainPreviewText("0");
        setSecondPreviewText("");
        firstOperandStatus();
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
        if (text.endsWith(".0")) {
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

            case R.id.btnLog:
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
                setOperationType(OperationType.DIVISION);
                break;

            case R.id.btnMultiplication:
                setOperationType(OperationType.MULTIPLICATION);
                break;

            case R.id.btnAddition:
                setOperationType(OperationType.ADDITION);
                break;

            case R.id.btnSubtraction:
                setOperationType(OperationType.SUBTRACTION);
                break;

            case R.id.btnEqual:
                if (operandsMustEvaluate) {
                    prosesOperands();
                }
                break;

        }
    }


    /*
     * Helper Methods
     * */

    private void appendOperandNumber(String number) {
        if (getMainPreviewText().isEmpty() || getMainPreviewText().equals("0")) {
            updateOperands(number);
            setMainPreviewText(number);
            return;
        }

        String newNumber = getMainPreviewText();
        newNumber = newNumber + number;
        updateOperands(newNumber);
        setMainPreviewText(newNumber);
    }

    private void clearAll() {
        setMainPreviewText("0");
        setSecondPreviewText("");
        firstOperandStatus();
    }

    private void clearLastNumber() {
        String newNumber;

        if (getMainPreviewText().isEmpty()) {
            newNumber = "0";
        } else {
            String number = getMainPreviewText();
            newNumber = number.substring(0, number.length() - 1);
        }

        updateOperands(newNumber);
        setMainPreviewText(newNumber);
    }

    private void updateOperands(String newNumber) {
        if (isFirstOperandActive) {
            firstOperand = convertStringToDouble(newNumber);
        } else if (isSecondOperandActive) {
            secondOperand = convertStringToDouble(newNumber);
        }
    }

    private void setOperationType(OperationType activeOperator) {
        setSecondPreviewText(convertDoubleToString(firstOperand));
        setMainPreviewText("");
        secondOperandStatus();
        isAlreadyEvaluated = false;

        this.activeOperator = activeOperator;
        setActiveOperatorPreview(activeOperator);
    }

    private void prosesOperands() {
        if (isAlreadyEvaluated) return;

        evaluationResult = evaluateOperands();
        double lastOperand = secondOperand;
        firstOperand = evaluationResult;
        setMainPreviewText(convertDoubleToString(evaluationResult));
        setSecondPreviewText(convertDoubleToString(lastOperand));
        isAlreadyEvaluated = true;
        alreadyEvaluatedStatus();
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

    private void firstOperandStatus() {
        operandsMustEvaluate = false;
        isFirstOperandActive = true;
        isSecondOperandActive = false;
        isAlreadyEvaluated = false;
    }

    private void secondOperandStatus() {
        isFirstOperandActive = false;
        isSecondOperandActive = true;
        operandsMustEvaluate = true;
    }

    private void alreadyEvaluatedStatus() {
        isFirstOperandActive = true;
        isSecondOperandActive = false;
        operandsMustEvaluate = true;
    }

    private double evaluate() {
        String stringToBeEvaluted = getMainPreviewText();
        final String str = stringToBeEvaluted.replace('÷', '/')
                .replace('×', '*');

        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (; ; ) {
                    if (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (; ; ) {
                    if (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else if (func.equals("log")) x = Math.log10(x);
                    else if (func.equals("ln")) x = Math.log(x);
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }

    private int factorialOf(int number) {
        return (number == 0 || number == 1) ? 1 : (number * factorialOf(number - 1));
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