package com.primeornotprime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int number;
    private int score;
    private boolean answer;

    public void onClickPrime(View view){
        answer = true;
        verifyAnswer();
        displayScore();
        displayRandomNumber();
    }

    public void onClickComposite(View view){
        answer = false;
        verifyAnswer();
        displayScore();
        displayRandomNumber();
    }

    private void verifyAnswer() {
        if (!(isPrime(number) ^ answer)) {
            score++;
            Toast.makeText(this, "Congratulations! You are correct!", Toast.LENGTH_SHORT).show();
        } else {
            score = score - 5;
            Toast.makeText(this, "You are wrong!", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, "Previous number: "+ number,Toast.LENGTH_SHORT).show();
    }

    private boolean isPrime(int value){
        Boolean temp = true;
        for (int divisor = 2; divisor < Math.sqrt(value); divisor++) {
            if (value % divisor == 0) {
                temp = false;
            }
        }
        return temp;
    }

    private void displayRandomNumber(){
        Random r = new Random();
        number = 2 + r.nextInt(1000);  // Random numbers: 2 - 999
        TextView tv = (TextView) findViewById(R.id.textViewNumber);
        tv.setText("" + number); // "" + int -> converts int to String
    }

    private void displayScore(){
        TextView tv = (TextView) findViewById(R.id.textViewScore);
        tv.setText("Your score is " + score + ".");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayRandomNumber();
    }


}
