package com.blogspot.sardinias.sardiniaquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SeventhQuestionActivity extends AppCompatActivity {
    // This method is necessary to pass the score to other activity
    public static final String QUIZ_DATA = "com.blogspot.sardinias.sardiniaquiz.QUIZDATA";

    // Global variables
    String name;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh_question);

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

        // Handle the answer a user has selected
        RadioGroup radioGroup = findViewById(R.id.radio_group);

        // First uncheck all buttons
        radioGroup.clearCheck();

        // Check which button was selected and update the score
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = group.findViewById(checkedId);

                switch (rb.getId()) {
                    case R.id.answer1_text:
                        score++;
                        Toast.makeText(SeventhQuestionActivity.this, "Correct! Keep going!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.answer2_text:
                        break;
                    case R.id.answer3_text:
                        break;
                }
            }
        });
    }

    // This method is called when nextButton is clicked
    public void nextButton(View view) {
        // Create an Intent for next activity
        Intent nextIntent = new Intent(SeventhQuestionActivity.this, EightQuestionActivity.class);

        // Bundle the name and score values to pass to the next activity
        Bundle b = new Bundle();
        b.putString("name", name);
        b.putInt("score", score);
        nextIntent.putExtra(QUIZ_DATA, b);

        // Start next activity
        startActivity(nextIntent);
    }
}
