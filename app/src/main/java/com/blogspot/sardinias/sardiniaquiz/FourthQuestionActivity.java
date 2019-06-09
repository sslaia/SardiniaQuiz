package com.blogspot.sardinias.sardiniaquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class FourthQuestionActivity extends AppCompatActivity {
    // This method is necessary to pass the score to other activity
    public static final String QUIZ_DATA = "com.blogspot.sardinias.sardiniaquiz.QUIZDATA";

    // Global variables
    String name;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_question);

        // Get the data from the previous screen (name)
        Intent i = getIntent();
        Bundle b = i.getBundleExtra(QUIZ_DATA);
        name = b.getString("name");
        score = b.getInt("score");

        // Create a score message
        String scoreMessage = name + "\'s score is " + score;

        // Display the previous user's score
        TextView scoreMessageView = findViewById(R.id.score_message);
        scoreMessageView.setText(scoreMessage);
    }

    // This method is called when nextButton is clicked
    public void nextButton(View view) {
        // Get the right checked boxes for score record, ignore other as they are wrong and 0 score
        // Get the first and second checkbox state
        CheckBox placeOfWorship = findViewById(R.id.place_of_worship);
        CheckBox watchTower = findViewById(R.id.watch_tower);

        if (placeOfWorship.isChecked() & watchTower.isChecked()) {
            score++;
        }
        // Create an Intent for next activity
        Intent nextIntent = new Intent(FourthQuestionActivity.this, FifthQuestionActivity.class);

        // Bundle the name and score values to pass to the next activity
        Bundle b = new Bundle();
        b.putString("name", name);
        b.putInt("score", score);
        nextIntent.putExtra(QUIZ_DATA, b);

        // Start next activity
        startActivity(nextIntent);
    }
}
