package com.example.demoapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int loginCount = 0;
    int logoutCount = 0;
    int result = 0;
    int num1;
    int num2;
    private TextView nameTextView;
    private TextView moodTextView;
    private TextView btncountTextView;
    private TextView resultTextView;
    private EditText editText1;
    private EditText editText2;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameTextView = findViewById(R.id.nameTextView);
        moodTextView = findViewById(R.id.moodTextview);
        btncountTextView = findViewById(R.id.btncount);
        resultTextView = findViewById(R.id.result);
        editText1 = findViewById(R.id.editText_1);
        editText2 = findViewById(R.id.editText_2);
        ImageView imageView1 = findViewById(R.id.imageview1);
        ImageView imageView2 = findViewById(R.id.imageview2);
        Button loginButton = findViewById(R.id.loginButton);
        Button logoutButton = findViewById(R.id.logoutButton);
        Button addButton = findViewById(R.id.addButton);
        Button subtractButton = findViewById(R.id.subtractButton);
        Button nextPageButton = findViewById(R.id.next_page_button);


        Clicker1 clicker1 = new Clicker1();
        Clicker2 clicker2 = new Clicker2();
        Clicker3 clicker3 = new Clicker3();
        Clicker4 clicker4 = new Clicker4();
        loginButton.setOnClickListener(clicker1);
        logoutButton.setOnClickListener(clicker1);
        addButton.setOnClickListener(clicker2);
        subtractButton.setOnClickListener(clicker2);
        imageView1.setOnClickListener(clicker3);
        imageView2.setOnClickListener(clicker3);
        nextPageButton.setOnClickListener(clicker4);


    }

    class Clicker1 implements View.OnClickListener {

        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.loginButton) {
                loginCount++;
                nameTextView.setText("n8fury");
                moodTextView.setText("Sluggish");
                btncountTextView.setText("Login Button was click" + loginCount + " Times");
                Toast.makeText(MainActivity.this, "Login Button was click" + loginCount + " Times", Toast.LENGTH_SHORT).show();
            } else if (v.getId() == R.id.logoutButton) {
                logoutCount++;
                nameTextView.setText("Zoy");
                moodTextView.setText("Cool");
                btncountTextView.setText("Logout Button was click" + logoutCount + " Times");
                Toast.makeText(MainActivity.this, "Logout Button was click" + logoutCount + " Times", Toast.LENGTH_SHORT).show();
            } else {
                btncountTextView.setText("No Button Clicked");
            }
        }
    }

    class Clicker2 implements View.OnClickListener {

        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View v) {
            try {
                num1 = Integer.parseInt(editText1.getText().toString());
                num2 = Integer.parseInt(editText2.getText().toString());

                if (v.getId() == R.id.addButton) {
                    result = num1 + num2;
                    resultTextView.setText("Result: " + result);

                } else if (v.getId() == R.id.subtractButton) {
                    result = num1 - num2;
                    resultTextView.setText("Result: " + result);
                } else {
                    resultTextView.setText("Result: ");
                }
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "Enter Value to Calculate", Toast.LENGTH_SHORT).show();
            }
        }
    }

    class Clicker3 implements View.OnClickListener {

        @Override
        public void onClick(View v) {

//            custom toast
            LayoutInflater inflater = getLayoutInflater();
            View customView = inflater.inflate(R.layout.custom_toast_layout, findViewById(R.id.custom_toast_layout));
            Toast toast = new Toast(MainActivity.this);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(customView);

            if (v.getId() == R.id.imageview1) {

                toast.show();
            } else if (v.getId() == R.id.imageview2) {
                toast.show();

            }

        }
    }

    class Clicker4 implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, Activity_2.class));
        }
    }

}