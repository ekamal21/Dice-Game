package com.example.midterm_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {
       Button depositBtn, withdrawBtn;
       EditText depositA, withdrawA;
       double amountToDeposit = 500;
       double amountToWithdraw = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        //this is for to go back arrow
        //also add parentActivityName inside of androidManifest.xml
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //initializing the buttons
        depositBtn  = (Button) findViewById(R.id.buttonDeposit);
        withdrawBtn = (Button) findViewById(R.id.buttonWithdraw);
        depositA = (EditText) findViewById(R.id.DepositField);
        withdrawA = (EditText) findViewById(R.id.WithdrawField);


        MyBankAccount info = (MyBankAccount) getIntent().getSerializableExtra("bank");

        //button to deposit when clicked
        depositBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(info != null) {
                    info.deposit(amountToDeposit);
                }
             Intent intent = new Intent(Activity3.this,MainActivity.class);
                intent.putExtra("afterchange",info);
                startActivity(intent);
            }
        });

          //button to withdraw
        withdrawBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(info != null) {
                    info.withdraw(amountToWithdraw);
                }
                Intent intent = new Intent(Activity3.this,MainActivity.class);
                intent.putExtra("afterchange",info);
                startActivity(intent);
            }
        });
    }
}