package com.example.questionarioimpacto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TermsConditionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_conditions);
    }


    public void acceptButtom(View view) {

        Intent intent = new Intent(TermsConditionsActivity.this, IdentificationActivity.class);
        startActivity(intent);

    }
}
