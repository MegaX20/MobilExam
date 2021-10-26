package com.example.mobilexamain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {

    Task task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button login = (Button) findViewById(R.id.loginM);

        Button rate = (Button) findViewById(R.id.rateM);

        Button qa = (Button) findViewById(R.id.qaM);

        Button review = (Button) findViewById(R.id.reviewM);

        Button search = (Button) findViewById(R.id.searchM);

        Button chose = (Button) findViewById(R.id.choseM);

        //Toast.makeText(MainActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                login();
            }
        });
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rate();

            }
        });
        qa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                qa();
            }
        });
        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                review();

            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();

            }
        });
        chose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chose();

            }
        });

    }
    public void login() {
        Intent intentP = new Intent(this, LoginActivity.class);
        startActivity(intentP);
    }
    public void rate() {
        Intent intentN = new Intent(this, RateActivity.class);
        startActivity(intentN);
    }
    public void qa() {
        Intent intentQ = new Intent(this, QaActivity.class);
        startActivity(intentQ);
    }
    public void review() {
        Intent intentR = new Intent(this, ReviewActivity.class);
        startActivity(intentR);
    }
    public void search() {
        Intent intentS = new Intent(this, SearchActivity.class);
        startActivity(intentS);
    }
    public void chose() {
        Intent intentC = new Intent(this, ChoseActivity.class);
        startActivity(intentC);
    }


}