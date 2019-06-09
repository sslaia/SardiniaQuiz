package com.blogspot.sardinias.sardiniaquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String QUIZ_DATA = "com.blogspot.sardinias.sardiniaquiz.QUIZDATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // This method is called when submitButton is clicked
    public void submitButton(View view) {
        // Create an Intent
        Intent intent = new Intent(this, FirstQuestionActivity.class);

        // Get the user name input to pass to the next activity
        EditText userNameView = findViewById(R.id.user_name_text);
        String userName = userNameView.getText().toString();

        intent.putExtra(QUIZ_DATA, userName);
        startActivity(intent);
    }
}