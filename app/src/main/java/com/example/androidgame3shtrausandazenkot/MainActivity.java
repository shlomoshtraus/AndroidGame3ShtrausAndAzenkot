package com.example.androidgame3shtrausandazenkot;

/*
==============================================================================
                                    Exercise 3

   Shlomo Shtraus ID 209303023 shloymi987@gmail.com
   Shlomo Azenkot ID 314646217 shlomiazn27@gmail.com
   Second year, Computer Science Department- Ashqelon College (Gan Yavne)
***********************************************************************

   Assignment:
   Getting a Game and then to make in it a couple types of fixes.

   Main Goals:
   Understand independently.
       Work on an existing plan.
       Perform maintenance (repairs) and improvements.

   Running:
   Go please to Class called "MainActivity.java". After-press on the green running button in order to run.
   When you finish press the "goBack" button and after the "Quit" button.

   Important!
   The app has been tested on
   Galaxy Nexus
   API 29
   Android 10.0

   (On other cell phones the display may be different)

===============================================================================
 */
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

                GameActivity.currentScore = 0; // because this variable is a static variable.
                score.setVisibility(View.INVISIBLE); // if someone presses the "final score" button before the game started.

                Intent i = new Intent(this, GameActivity.class);
                startActivity(i);
                break;

            case R.id.final_score: // show the finely score

                score.setText("Your final score is: " + GameActivity.currentScore);
                if(score.getVisibility()==View.VISIBLE){
                    score.setVisibility(View.INVISIBLE);
                }else{
                    score.setVisibility(View.VISIBLE);
                }
                break;

            case R.id.quitButton: // exits the app.
                // finish() did not work well so I used finishAffinity()
                //  https://stackoverflow.com/questions/53494605/
                finishAffinity();
                break;
        }
    }

}