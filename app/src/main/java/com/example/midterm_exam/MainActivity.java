package com.example.midterm_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
 TextView outPutField;
 Button playDiceGame, CheckAccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing the button and textview
        outPutField = (TextView) findViewById(R.id.editTextView);
        playDiceGame = (Button) findViewById(R.id.button1);
        CheckAccount = (Button) findViewById(R.id.button2);


        outPutField = (TextView) findViewById(R.id.editTextView);
        //MyBankAccount info = (MyBankAccount) getIntent().getSerializableExtra("bankkey");

        //play game button
        playDiceGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String outPut = playDiceGame.getText().toString();
                Intent intent = new Intent(MainActivity.this,Activity2.class);
                intent.putExtra("intkey", outPut);
                startActivity(intent);
            }
        });

        //check bank account button
       CheckAccount.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               MyBankAccount myBankAccount = new MyBankAccount(8790428,500,"Bank of America");
               Intent intent = new Intent(MainActivity.this,Activity3.class);
               intent.putExtra("bank", myBankAccount);
               startActivity(intent);
           }
       });

       //getting information from the MyBankAccount and setting it to the textview
        MyBankAccount info = (MyBankAccount) getIntent().getSerializableExtra("afterchange");
        if(info != null){
            String bankName = String.valueOf(info.getBankName());
            String balance = String.valueOf(info.getBalance());
            String accountNumber = String.valueOf(info.getAccountNumber());
            outPutField.setText("Account Number: " + accountNumber + "\n" +"Balance: " + balance + "\n" +"Bank: " + bankName);
        }
    }
}