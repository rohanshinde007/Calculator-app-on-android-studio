package com.mul.calculation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class MainActivity extends AppCompatActivity {

    TextView text1,text2;
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonAdd, buttonSub,
            buttonMul, buttonDivision, buttonEqual, buttonDel, buttonDot, Remainder,buttonBackspace;
    String calculate="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonDot = (Button) findViewById(R.id.buttondot);
        buttonAdd = (Button) findViewById(R.id.add);
        buttonSub = (Button) findViewById(R.id.sub);
        buttonMul = (Button) findViewById(R.id.multiplication);
        buttonDivision = (Button) findViewById(R.id.division);
        Remainder = (Button) findViewById(R.id.button_per);
        buttonDel = (Button) findViewById(R.id.del);
        buttonEqual = (Button) findViewById(R.id.equals);
        buttonBackspace = (Button)findViewById(R.id.backspace);

        text1 = (TextView) findViewById(R.id.output);
        text2 = (TextView) findViewById(R.id.outpute);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text2.getText().length()>32){
                    Toast.makeText(MainActivity.this, "Number too long", Toast.LENGTH_SHORT).show();
                }else{
                    text2.setText(text2.getText()+"0");
                    calculate=calculate+"0";
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text2.getText().length()>32){
                    Toast.makeText(MainActivity.this, "Number too long", Toast.LENGTH_SHORT).show();
                }else{
                    text2.setText(text2.getText()+"1");
                    calculate=calculate+"1";
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text2.getText().length()>32){
                    Toast.makeText(MainActivity.this, "Number too long", Toast.LENGTH_SHORT).show();
                }else{
                    text2.setText(text2.getText()+"2");
                    calculate=calculate+"2";
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text2.getText().length()>32){
                    Toast.makeText(MainActivity.this, "Number too long", Toast.LENGTH_SHORT).show();
                }else{
                    text2.setText(text2.getText()+"3");
                    calculate=calculate+"3";
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text2.getText().length()>32){
                    Toast.makeText(MainActivity.this, "Number too long", Toast.LENGTH_SHORT).show();
                }else{
                    text2.setText(text2.getText()+"4");
                    calculate=calculate+"4";
                }
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text2.getText().length()>32){
                    Toast.makeText(MainActivity.this, "Number too long", Toast.LENGTH_SHORT).show();
                }else{
                    text2.setText(text2.getText()+"5");
                    calculate=calculate+"5";
                }
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text2.getText().length()>32){
                    Toast.makeText(MainActivity.this, "Number too long", Toast.LENGTH_SHORT).show();
                }else{
                    text2.setText(text2.getText()+"6");
                    calculate=calculate+"6";
                }
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text2.getText().length()>32){
                    Toast.makeText(MainActivity.this, "Number too long", Toast.LENGTH_SHORT).show();
                }else{
                    text2.setText(text2.getText()+"7");
                    calculate=calculate+"7";
                }
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text2.getText().length()>32){
                    Toast.makeText(MainActivity.this, "Number too long", Toast.LENGTH_SHORT).show();
                }else{
                    text2.setText(text2.getText()+"8");
                    calculate=calculate+"8";
                }
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text2.getText().length()>32){
                    Toast.makeText(MainActivity.this, "Number too long", Toast.LENGTH_SHORT).show();
                }else{
                    text2.setText(text2.getText()+"9");
                    calculate=calculate+"9";
                }
            }
        });

        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1.setText("");
                text2.setText("");
                calculate="";
            }
        });



        buttonBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(text2.getText()!=""){
                    if(text2.getText().charAt(text2.getText().length()-1)>='1' && text2.getText().charAt(text2.getText().length()-1)<='9') {
                        if(text2.getText().length()>=1){
                            text2.setText(text2.getText().toString().substring(0, text2.getText().length() - 1));
                            calculate=calculate.substring(0,calculate.length()-1);
                        }else{
                            text2.setText("");
                        }
                    }else if(text2.getText().charAt(text2.getText().length()-1)=='('){
                        text2.setText(text2.getText().toString().substring(0, text2.getText().length() - 4));
                        calculate=calculate.substring(0,calculate.length()-4);
                    }
                }else if(text2.getText()==""){

                }
            }
        });



        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text2.setText(text2.getText()+".");
                calculate=calculate+".";
            }
        });


        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(calculate!=""){
                    calculate="("+calculate+")";
                }
                if(text2.getText().toString()!=""){
                    calculate=calculate+"/";
                    text2.setText(text2.getText()+"/");
                }
            }
        });


       Remainder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(calculate!=""){
                    calculate="("+calculate+")";
                }
                if(text2.getText().toString()!=""){
                    calculate=calculate+"%";
                    text2.setText(text2.getText()+"%");
                }
            }
        });



     buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(calculate!=""){
                    calculate="("+calculate+")";
                }
                if(text2.getText().toString()!=""){
                    calculate=calculate+"*";
                    text2.setText(text2.getText()+"X");
                }
            }
        });





        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(calculate!=""){
                    calculate="("+calculate+")";
                }
                if(text2.getText().toString()!=""){
                    calculate=calculate+"-";
                    text2.setText(text2.getText()+"-");
                }
            }
        });



        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(calculate!=""){
                    calculate="("+calculate+")";
                }
                if(text2.getText().toString()!=""){
                    calculate=calculate+"+";
                    text2.setText(text2.getText()+"+");
                }
            }
        });


        buttonEqual = (Button)findViewById(R.id.equals);
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
                if(calculate!=""){
                    try{
                        if(text2.getText().toString().contains("^")){
                            calculate=calculate+")";
                        }
                        Log.d("calculation",calculate);
                        Double result=(Double)engine.eval(calculate);
                        Log.d("result",result.toString());
                        if(result%1==0) {
                            String a=String.format("%.0f", result);
                            text1.setText(text2.getText());
                            text2.setText(a);
                            Log.d("intcheck","yes");
                        }else{
                            text1.setText(text2.getText());
                            text2.setText(result.toString());
                            Log.d("intcheck","no");
                        }
                    }catch(Exception e){
                        text1.setText(text2.getText());
                        text2.setText("");
                    }
                }
            }
        });
    }
}