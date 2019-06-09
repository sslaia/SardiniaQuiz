package com.blogspot.sardinias.sardiniaquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EightQuestionActivity extends AppCompatActivity {
    // This method is necessary to pass the score to other activity
    public static final String QUIZ_DATA = "com.blogspot.sardinias.sardiniaquiz.QUIZDATA";

    // Global variables
    String name;
    String message;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight_question);

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
        // Get the user input to pass to the next activity
        EditText userInputView = findViewById(R.id.q8_input_text);
        String userInput = userInputView.getText().toString();
        String correctAnswer  = "smeralda";

        if (userInput.toLowerCase().contains(correctAnswer.toLowerCase())) {
            score++;
            message = "Correct!\nCosta Smeralda is the most expensive location in Europe where celebrities, business leaders, and other affluent visitors spend their holidays\n(From Wikipedia).";

        } else {
            message = "Thank you, but it is Costa Smeralda.\nIndeed Costa Smeralda is the most expensive location in Europe where celebrities, business leaders, and other affluent visitors spend their holidays\n(From Wikipedia).";
        }

        // Create an Intent for next activity
        Intent nextIntent = new Intent(EightQuestionActivity.this, EightQuestionExtraActivity.class);

        // Bundle the name and score values to pass to the next activity
        Bundle b = new Bundle();
        b.putString("name", name);
        b.putString("message", message);
        b.putInt("score", score);
        nextIntent.putExtra(QUIZ_DATA, b);

        // Start next activity
        startActivity(nextIntent);
    }
}
