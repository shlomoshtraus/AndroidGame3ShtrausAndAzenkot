package com.example.androidgame3shtrausandazenkot;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button buttonPlay = findViewById(R.id.buttonPlay);
        final Button buttonQuit = findViewById(R.id.quitButton);
        final Button finalScore = findViewById(R.id.final_score);
        buttonPlay.setOnClickListener(this);
        buttonQuit.setOnClickListener(this);
        finalScore.setOnClickListener(this);
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override

    public void onClick(View view) {
        TextView score = findViewById(R.id.final_score_text);
        switch(view.getId()){
            case R.id.buttonPlay: // start the game.

//                GameActivity.highestScore = 0; // because this variable is a static variable.
                score.setVisibility(View.INVISIBLE); // if someone presses the "final score" button before the game started.

                Intent i = new Intent(this, GameActivity.class);
                startActivity(i);
                break;

            case R.id.final_score: // show the finely score

                score.setText("Your highest score is: " + GameActivity.highestScore);
                if(score.getVisibility()==View.VISIBLE){
                    score.setVisibility(View.INVISIBLE);
                }else{
                    score.setVisibility(View.VISIBLE);
                }
                break;

            case R.id.quitButton: // exits the app.
                finish();
        }
    }

}