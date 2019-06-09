package com.blogspot.sardinias.sardiniaquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {
    // This method is necessary to pass the score to other activity
    public static final String QUIZ_DATA = "com.blogspot.sardinias.sardiniaquiz.QUIZDATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        // Get the data from previous screen
        Intent i = getIntent();
        Bundle b = i.getBundleExtra(QUIZ_DATA);
        String userName = b.getString("name");
        int score = b.getInt("score");

        // Get the winning prize strings
        String firstPrize = getString(R.string.first_prize);
        String secondPrize = getString(R.string.second_prize);
        String thirdPrize = getString(R.string.third_prize);

        // Display winning prize
        // First find out the score and award the prize
        if (score >= 9) {
            String prizeMessage = "Hi " + userName + "\n" + firstPrize;
            TextView prizeMessageView = findViewById(R.id.prize_message);
            prizeMessageView.setText(prizeMessage);
        }
        if (score <= 8 && score >= 7) {
            String prizeMessage = "Hi " + userName + "\n" + secondPrize;
            TextView prizeMessageView = findViewById(R.id.prize_message);
            prizeMessageView.setText(prizeMessage);
        }
        if (score <= 6 && score >= 5) {
            String prizeMessage = "Hi " + userName + "\n" + thirdPrize;
            TextView prizeMessageView = findViewById(R.id.prize_message);
            prizeMessageView.setText(prizeMessage);
        }
        if (score <= 4) {
            String prizeMessage = "Hi " + userName + "\nIt\'s time to explore Sardinia again.\nFor sure you will win next time.";
            TextView prizeMessageView = findViewById(R.id.prize_message);
            prizeMessageView.setText(prizeMessage);
        }
    }

    // This method is called when nextButton is clicked
    public void nextButton(View view) {
        // Get the checkbox message and pass it to final screen

        String finalMessage = "Greeting!";

        // Get the via mail state
        CheckBox viaEmail = findViewById(R.id.via_email);

        // Get the via mail state
        CheckBox viaMail = findViewById(R.id.via_mail);

        if (viaEmail.isChecked() && !viaMail.isChecked()) {
            finalMessage = "Sure! We'll send the Sardinia Pack per email to you";
        }
        if (viaMail.isChecked() && !viaEmail.isChecked()) {
            finalMessage = "Great! You'll receive the Sardinia Pack in your mailbox soon.";
        }
        if (viaEmail.isChecked() && viaMail.isChecked())  {
            finalMessage = "Sure! We'll send the Sardinia Pack per mail and email to you";
        }
        if (!viaEmail.isChecked() && !viaMail.isChecked())  {
            finalMessage = "Lovely greetings from Sardnia!";
        }

        // Create an Intent for next activity
        Intent nextIntent = new Intent(FinalActivity.this, EndActivity.class);
        nextIntent.putExtra(QUIZ_DATA, finalMessage);

        // Start next activity
        startActivity(nextIntent);
    }
}
