package com.example.midterm_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileReader;
import java.util.Random;

public class Activity2 extends AppCompatActivity {
    Button button, button2,playAgain;
    TextView textView, textView1, textView2, textPoint1,textPoint2;
    ImageView Dice_img1, Dice_img2, Dice_img3;
    int totalCountp1=0, totalCountp2 =0;
    int sumOfDice =0;
    int player1Turn=0, player2Turn =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        playAgain = (Button) findViewById(R.id.playAgain);
        //this is for to go back arrow
        //also add parentActivityName inside of androidManifest.xml
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // array for the dice images
          int dice[] = {R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3,
                R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6};

        //initializing the buttons and textviews
        button = findViewById(R.id.player_1btn);
        button2 = findViewById(R.id.player_2btn);
        textView = findViewById(R.id.textView);
        textView1 = findViewById(R.id.textView8);
        textView2 = findViewById(R.id.textView7);
        textPoint1  = findViewById(R.id.totalPointsp1);
        textPoint2  = findViewById(R.id.totalPointsp2);


        //this is rolling dice randomly
        Dice_img1 = findViewById(R.id.imageView2);
        Dice_img2 = findViewById(R.id.imageView3);
        Dice_img3 = findViewById(R.id.imageView4);

        //restart the game
        playAgain.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        } );

        // player 1 button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame();
                GiveTurns();
                textView1.setText("" + sumOfDice);
                totalCountp1 += sumOfDice;
                textPoint1.setText("" +  totalCountp1);
                textView.setText(winner());
            }
        });

        //player 2 button
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playGame();
                GiveTurns();
                textView2.setText("" + sumOfDice);
                totalCountp2 += sumOfDice;
                textPoint2.setText("" +  totalCountp2);
                textView.setText(winner());

            }
        });
    }
    public void playGame(){

        // array for the dice images
        int dice[] = {R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3,
                R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6};

        //random generator
        Random random = new Random();
        int roll_1 =random.nextInt(6);
        int roll_2 = random.nextInt(6);
        int roll_3 = random.nextInt(6);


        //sum of the dice
        sumOfDice = roll_1 + roll_2+roll_3 + 3;


        // set the images from the array by the index
        // position of the numbers generated
        Dice_img1.setImageResource(dice[roll_1]);
        Dice_img2.setImageResource(dice[roll_2]);
        Dice_img3.setImageResource(dice[roll_3]);
        player1Turn++;
        player2Turn++;


    }
    //the method to declare a winner
    public String  winner() {
        String result = "";
        if (totalCountp1 >= 100 || totalCountp2 >= 100) {
            if (totalCountp1 > totalCountp2) {
                 result = "player 1 wins";
                return result;
            }
            if (totalCountp1 < totalCountp2) {
                result = "player 2 wins";
                return result;
            }
        }
        return result;
    }

    //give them 3 turns each players between plays
    public void GiveTurns(){
        if(player1Turn ==3){
            button.setClickable(false);
            button2.setClickable(true);
            player2Turn =0;

        }
        if(player2Turn ==3){
            button2.setClickable(false);
            button.setClickable(true);
            player1Turn =0;
        }
    }
}