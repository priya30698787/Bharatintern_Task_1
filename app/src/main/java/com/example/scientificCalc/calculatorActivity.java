package com.example.scientificCalc;

import android.annotation.SuppressLint;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.Objects;

public class calculatorActivity extends AppCompatActivity {
    private TextView Screen;
    private Button Ac, Point, One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Zero, DIV, Log, Pow, Mul, Ans, Minus, Openbracet, Closebracet, Plus, Equal, Delete;
    private String input, Answer;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        Screen = findViewById(R.id.screen);
        Ac = findViewById(R.id.ac);
        Point = findViewById(R.id.point);
        One = findViewById(R.id.one);
        Two = findViewById(R.id.two);
        Three = findViewById(R.id.three);
        Four = findViewById(R.id.four);
        Five = findViewById(R.id.five);
        Six = findViewById(R.id.six);
        Seven = findViewById(R.id.seven);
        Eight = findViewById(R.id.eight);
        Nine = findViewById(R.id.nine);
        Zero = findViewById(R.id.zero);
        DIV = findViewById(R.id.div);
        Mul = findViewById(R.id.mul);
        Minus = findViewById(R.id.minus);
        Plus = findViewById(R.id.plus);
        Openbracet = findViewById(R.id.openbracet);
        Closebracet = findViewById(R.id.closebracet);
        Log = findViewById(R.id.log);
        Pow = findViewById(R.id.pow);
        Ans = findViewById(R.id.answer);
        Equal = findViewById(R.id.equal);
        Delete = findViewById(R.id.delete);
    }

    //add onClick listner for each button
    public void ButtonClick(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data) {
            case "AC":
                input = "";
                break;
            case "x":
                Solve();
                input += "*";
                break;
            case "ANS":
                input += Answer;
                break;
            case "=":
                Solve();
                Answer = input;
                break;
            case"^":
                Solve();
                input+="^";
                break;
            case"DEL":
                input= input.substring(0,input.length()-1);
                break;
            default:
                if (input == null) {
                    input = "";
                }
                if (data.equals("+") || data.equals("-") || data.equals("/")) {
                    Solve();
                }
                input += data;
        }
        Screen.setText(input);
    }

    private void Solve() {
        if (input.split("\\*").length == 2) {
            String[] number = input.split("\\*");
            try {
                double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = mul+"";
            } catch (Exception ignored) {

            }
        } else if (input.split("\\÷").length == 2) {
            String[] number = input.split("÷");
            try {
                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = div+"";
            } catch (Exception ignored) {

            }
        }
        else if (input.split("\\^").length == 2) {
            String[] number = input.split("\\^");
            try {
                double pow = Math.pow (Double.parseDouble(number[0]) , Double.parseDouble(number[1]));
                input = pow+"";
            } catch (Exception ignored) {

            }
        }
        else if (input.split("\\+").length == 2) {
            String[] number = input.split("\\+");
            try {
                double plus = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = plus+"";
            } catch (Exception ignored) {

            }
        }
        else if (input.split("-").length>1) {
            String[] number = input.split("-");
            if(Objects.equals(number[0], "") && number.length==2){
                number[0]=0+"";
            }
            try {
                double minus=0;
                if(number.length==2) {
                    minus = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                }
                else if(number.length==3){
                    minus= -Double.parseDouble(number[1]) - Double.parseDouble(number[2]);
                }
                input = minus+"";
            }
            catch (Exception ignored) {

            }
        }
      String[] n =input.split("\\.");
        if(n.length>1){
            if(n[1].equals("0")){
                input=n[0];
            }
        }
      Screen.setText(input);
    }
}
