package com.blogspot.sardinias.sardiniaquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {
    public static final String QUIZ_DATA = "com.blogspot.sardinias.sardiniaquiz.QUIZDATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        // Get the Intent from previous activity
        Intent intent = getIntent();
        String finalMessage = intent.getStringExtra(QUIZ_DATA);

        // Capture the layout's TextView and set the string as its text
        TextView finalMessageView = findViewById(R.id.final_message);
        finalMessageView.setText(finalMessage);
    }
}
