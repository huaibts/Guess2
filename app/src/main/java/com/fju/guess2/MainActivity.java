package com.fju.guess2;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random r = new Random();
    int n = r.nextInt(100)+1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Button button = (Button) findViewById(R.id.b_button);
    }
    public void guess2(View view){
        EditText edguess = (EditText) findViewById(R.id.ed_guess);
        int guess = Integer.parseInt(edguess.getText().toString());
        int min = 1;
        int max = 100;

        if(guess < min){
            Toast.makeText(this, "請再輸入一次", Toast.LENGTH_LONG).show();
        }else if(guess > max){
            Toast.makeText(this, "請再輸入一次", Toast.LENGTH_LONG).show();
        }else if (guess == n){
            new AlertDialog.Builder(this)
                    .setTitle("恭喜!!!")
                    .setMessage("答對了!!!")
                    .setPositiveButton("OK", null)
                    .show();
        }else if (guess>=min && guess<=max && guess<n){
            Toast.makeText(this, "大一點", Toast.LENGTH_SHORT).show();
            min = guess;
            TextView numbermin = (TextView) findViewById(R.id.t_min);
            numbermin.setText(Integer.toString(guess));
         //   return;

        }else if (guess>=min && guess<=max && guess>n){
            Toast.makeText(this, "小一點", Toast.LENGTH_SHORT).show();
            max = guess;
            TextView numbermax = (TextView) findViewById(R.id.t_max);
            numbermax.setText(Integer.toString(guess));
        }

    }
}
