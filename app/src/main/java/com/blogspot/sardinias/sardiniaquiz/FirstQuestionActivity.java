package com.blogspot.sardinias.sardiniaquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FirstQuestionActivity extends AppCompatActivity {
    // This method is necessary to pass the score to other activity
    public static final String QUIZ_DATA = "com.blogspot.sardinias.sardiniaquiz.QUIZDATA";

    // Global variables
    String name;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_question);
//
        // Get the data from the previous screen (name)
        Intent previousIntent = getIntent();
        name = previousIntent.getStringExtra(MainActivity.QUIZ_DATA);

        String userGreeting = "Hi " + name + ",\nwelcome to Sardinia Quiz app.\nShow your love of Sardinia and win a prize!";

        // Write the user's welcome message
        TextView userGreetingView = findViewById(R.id.user_greeting);
        userGreetingView.setText(userGreeting);

        // Handle the answer a user has seleted in the radio group
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
                        break;
                    case R.id.answer2_text:
                        break;
                    case R.id.answer3_text:
                        score++;
                        Toast.makeText(FirstQuestionActivity.this, "Correct! Keep going!", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    // This method is called when nextButton is clicked
    public void nextButton(View view) {
        // Create an Intent for next activity
        Intent nextIntent = new Intent(FirstQuestionActivity.this, SecondQuestionActivity.class);

        // Bundle the name and score values to pass to the next activity
        Bundle b = new Bundle();
        b.putString("name", name);
        b.putInt("score", score);
        nextIntent.putExtra(QUIZ_DATA, b);

        // Start next activity
        startActivity(nextIntent);
    }
}
