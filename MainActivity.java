package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA=0,scoreTeamB=0,bufferA=0,bufferB=0,counter=0;
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * Displays the given score for Team A.
     */
    public void touchDownA(View v){
        scoreTeamA=scoreTeamA+6;
        displayForTeamA(scoreTeamA);
    }

    public void fieldGoalA(View v){
        scoreTeamA=scoreTeamA+3;
        displayForTeamA(scoreTeamA);
    }

    public void extraA(View v){
        scoreTeamA=scoreTeamA+1;
        displayForTeamA(scoreTeamA);
    }
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void touchDownB(View v){
        scoreTeamB=scoreTeamB+6;
        displayForTeamB(scoreTeamB);
    }

    public void fieldGoalB(View v){
        scoreTeamB=scoreTeamB+3;
        displayForTeamB(scoreTeamB);
    }

    public void extraB(View v){
        scoreTeamB=scoreTeamB+1;
        displayForTeamB(scoreTeamB);
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void resetScore(View v){
        message="ROUND 1";
        scoreTeamA=0;
        scoreTeamB=0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        counter=0;
        displayMessage(message);
        enable(v);
    }

    public void foulA(View v){
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
    }

    public void foulB(View v){
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
    }
    private void displayMessage(String message) {
        TextView displayWinner = (TextView) findViewById(R.id.winner);
        displayWinner.setText(message);
    }

    public void disable(View v){
        Button b= (Button) findViewById(R.id.nr);
        b.setEnabled(false);
    }
    public void enable(View v){
        Button b= (Button) findViewById(R.id.nr);
        b.setEnabled(true);
    }

    public void nextRound(View v){
        counter++;
        if(counter==3)
        {
            disable(v);
        }


        bufferA= bufferA + scoreTeamA;
            scoreTeamA=0;
            bufferB= bufferB + scoreTeamB;
            scoreTeamB = 0;
            displayForTeamA(scoreTeamA);
            displayForTeamB(scoreTeamB);
            if(counter==3)
                message="FINAL ROUND";
            else
                message="ROUND " + (counter+1);
            displayMessage(message);


    }
    public void result(View v) {
        if (bufferA > bufferB) {
            message = "Team A wins";
            displayMessage(message);
        }
        else
        {
            message = "Team B wins";
            displayMessage(message);
        }
    }
}
