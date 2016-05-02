package com.example.asha.mathquiz;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.text.TextWatcher;
import android.text.Editable;
import android.widget.ImageView;

import junit.framework.TestCase;

import org.w3c.dom.Text;

import java.util.Random;
public class MainActivity extends AppCompatActivity {
    int a;
    int b;
    int userAdd;
    int userSubtract;
    int userTimes;
    int counter = 0;
    int correctPlus;
    int correctMinus;
    int correctTimes;
    TextView results;
    EditText add;
    EditText subtract;
    EditText timesEditText;

    public void update(){
        Random random = new Random();

        a = random.nextInt(11);
        b = random.nextInt(11);


        correctPlus = a+b;
        correctMinus = a-b;
        correctTimes = a*b;

        updateAdd();
        updateSubtract();
        updateMultiply();
    }
    public void updateAdd(){
        TextView plus = (TextView) findViewById(R.id.plus);
        plus.setText(a + " + " + b);
    }
    public void updateSubtract(){
        TextView minus = (TextView) findViewById(R.id.minus);
        minus.setText(a + " - " + b);

    }
    public void updateMultiply(){
        TextView times = (TextView) findViewById(R.id.times);
        times.setText(a + " * " + b);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        update();

        results = (TextView) findViewById(R.id.results);

        add = (EditText) findViewById(R.id.PlusAnswer);
        add.addTextChangedListener(addListener);
        subtract = (EditText) findViewById(R.id.MinusAnswer);
        subtract.addTextChangedListener(subtractListener);
        timesEditText = (EditText) findViewById(R.id.TimesAnswer);
        timesEditText.addTextChangedListener(timesListener);



        Button submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(submitListener);
        Button reset = (Button) findViewById(R.id.resetButton);
        reset.setOnClickListener(resetListener);




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private TextWatcher addListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            userAdd = Integer.parseInt(s.toString(), 10);

        }
    };

    private TextWatcher subtractListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            userSubtract = Integer.parseInt(s.toString(), 10);

        }
    };

    private TextWatcher timesListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            userTimes = Integer.parseInt(s.toString(), 10);

        }
    };

    private View.OnClickListener submitListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (correctPlus == userAdd) {
                counter++;
            }
            if (correctMinus == userSubtract) {
                counter++;
            }
            if (correctTimes == userTimes) {
                counter++;
            }
            correct(counter);
        }
    };
    public void correct(int count){
        ImageView first = (ImageView)findViewById(R.id.first);
        ImageView second = (ImageView)findViewById(R.id.second);
        ImageView third = (ImageView)findViewById(R.id.third);

        results.setText("You got " + count + " problems right!");
        if(count == 1){
            second.setVisibility(View.VISIBLE);

        }
        if(count == 2){
            first.setVisibility(View.VISIBLE);
            third.setVisibility(View.VISIBLE);

        }
        if(count ==3){
            first.setVisibility(View.VISIBLE);
            third.setVisibility(View.VISIBLE);
            second.setVisibility(View.VISIBLE);


        }



    }

    private View.OnClickListener resetListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            update();
            add.setText("");
            subtract.setText("");
            timesEditText.setText("");

        }
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
