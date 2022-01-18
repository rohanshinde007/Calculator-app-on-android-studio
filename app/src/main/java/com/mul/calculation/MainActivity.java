package com.mul.calculation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import static java.security.AccessController.getContext;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity  {

    TextView text1,text2;
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonAdd, buttonSub,
            buttonMul, buttonDivision, buttonEqual, buttonDel, buttonDot, Remainder,buttonBackspace,history;
    String calculate="";
    DatabaseHandler db;
    TextToSpeech textToSpeech;
    HorizontalScrollView hzw;
    boolean ischeval;
    CheckBox ch;
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



        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

                // if No error is found then only it will run
                if(i!=TextToSpeech.ERROR){
                    // To Choose language of speech
                    textToSpeech.setLanguage(Locale.US);
                }
            }
        });

        ch = (CheckBox) findViewById(R.id.ch);
       ch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if (ch.isChecked()){
                   textToSpeech.shutdown();
               }else {
                   textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                       @Override
                       public void onInit(int i) {

                           // if No error is found then only it will run
                           if(i!=TextToSpeech.ERROR){
                               // To Choose language of speech
                               textToSpeech.setLanguage(Locale.US);
                           }
                       }
                   });
               }
           }
       });

        db=new DatabaseHandler(this);
        history = (Button) findViewById(R.id.history);
      history.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Intent a = new Intent(MainActivity.this,calculated.class);
              startActivity(a);
          }
      });


hzw =(HorizontalScrollView) findViewById(R.id.hzw);
hzw.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        hzw.post(new Runnable() {
            @Override
            public void run() {
                hzw.fullScroll(View.FOCUS_RIGHT);
            }
        });
    }
});
        text1 = (TextView) findViewById(R.id.output);

        text2 = (TextView) findViewById(R.id.outpute);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    text2.setText(text2.getText()+"0");
                    calculate=calculate+"0";
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    text2.setText(text2.getText()+"1");
                    calculate=calculate+"1";

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    text2.setText(text2.getText()+"2");
                    calculate=calculate+"2";

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    text2.setText(text2.getText()+"3");
                    calculate=calculate+"3";

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    text2.setText(text2.getText()+"4");
                    calculate=calculate+"4";
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    text2.setText(text2.getText()+"5");
                    calculate=calculate+"5";

            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    text2.setText(text2.getText()+"6");
                    calculate=calculate+"6";
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    text2.setText(text2.getText()+"7");
                    calculate=calculate+"7";
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    text2.setText(text2.getText()+"8");
                    calculate=calculate+"8";

            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    text2.setText(text2.getText()+"9");
                    calculate=calculate+"9";

            }
        });

        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1.setText("");
                text2.setText("");
                calculate="";
                textToSpeech.speak("Delete",TextToSpeech.QUEUE_FLUSH,null);
            }
        });



        buttonBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){


                String r =text2.getText().toString();
                if (r.length()>1){
                    r = r.substring(0,r.length()-1);
                    text2.setText(r);
                }else  if (r.length()<=1){
                    text2.setText("");

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
                if(calculate!="") {

                    try {
                        if (text2.getText().toString().contains("^")) {
                            calculate = calculate + ")";
                        }
                        Double result = (Double) engine.eval(calculate);
                        if (result % 1 == 0) {
                            String a = String.format("%.0f", result);
                            text1.setText(text2.getText());
                            text2.setText(a);

                            textToSpeech.speak("the answer is " + text2.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);


                        } else {
                            text1.setText(text2.getText());
                            text2.setText(result.toString());
                            textToSpeech.speak("the answer is " + text2.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);

                        }
                        String text = text1.getText().toString()+" = "+text2.getText().toString();
                        db  = new DatabaseHandler(MainActivity.this);
                        boolean sucess = db.insertData(text);
                    } catch (Exception e) {
                        text1.setText(text2.getText());
                        text2.setText("");
                        textToSpeech.speak("sir please try valid calculation", TextToSpeech.QUEUE_FLUSH, null);
                    }
                }

            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case  R.id.item1:
       Intent i  = new Intent(MainActivity.this,MoreApps.class);
         startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }


}

