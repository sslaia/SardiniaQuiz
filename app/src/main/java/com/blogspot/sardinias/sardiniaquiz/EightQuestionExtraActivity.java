package com.blogspot.sardinias.sardiniaquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EightQuestionExtraActivity extends AppCompatActivity {
    // This method is necessary to pass the score to other activity
    public static final String QUIZ_DATA = "com.blogspot.sardinias.sardiniaquiz.QUIZDATA";

    // Global variables
    String name;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight_question_extra);

        // Get the data from the previous screen (name)
        Intent i = getIntent();
        Bundle b = i.getBundleExtra(QUIZ_DATA);
        name = b.getString("name");
        String message = b.getString("message");
        score = b.getInt("score");

        // Create a score message
        String scoreMessage = name + "\'s score is " + score;

        // Display the previous user's score
        TextView scoreMessageView = findViewById(R.id.score_message);
        scoreMessageView.setText(scoreMessage);

        TextView questionText = findViewById(R.id.question_text);
        questionText.setText(message);
    }

    // This method is called when nextButton is clicked
    public void nextButton(View view) {
        // Create an Intent for next activity
        Intent nextIntent = new Intent(EightQuestionExtraActivity.this, NinthQuestionActivity.class);

        // Bundle the name and score values to pass to the next activity
        Bundle b = new Bundle();
        b.putString("name", name);
        b.putInt("score", score);
        nextIntent.putExtra(QUIZ_DATA, b);

        // Start next activity
        startActivity(nextIntent);
    }
}
