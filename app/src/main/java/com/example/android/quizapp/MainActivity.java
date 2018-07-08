package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    // Set up values used later in the application, testIfAllChecked tests if the user answered all of
    // the questions, score keeps track of the points cored by the user

    int score = 0;
    String contestantName = "";
    int testIfAllChecked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitScore(View view) {

    //  Retrieve and save the player's name

        TextView contestantNameText = (TextView) findViewById(R.id.contestant_name);
        String contestantName = contestantNameText.getText().toString();

    //  Test if the correct radio button has been chosen

        RadioButton answer3question1Button = (RadioButton) findViewById(R.id.question1_answer3);
        boolean answer3question1 = answer3question1Button.isChecked();
        if (answer3question1) {
            score += 1;
        }

    //  Checks if the correct free form answer was input by the player/ compares the correct answer
    //  against the player's answer ignoring case, if the value match the returned integer is 0'

        TextView question2_answer = (TextView) findViewById(R.id.question2_answer);
        String answerQuestion2 = question2_answer.getText().toString();
        int compareValueQuestion2 = answerQuestion2.compareToIgnoreCase("Galileo");
        if (compareValueQuestion2 == 0) {
            score += 1;
        }

        RadioButton answer1question3Button = (RadioButton) findViewById(R.id.question3_answer1);
        boolean answer1question3 = answer3question1Button.isChecked();
        if (answer1question3) {
            score += 1;
        }

        RadioButton answer1question4Button = (RadioButton) findViewById(R.id.question4_answer1);
        boolean answer1question4 = answer1question4Button.isChecked();
        if (answer1question4) {
            score += 1;
        }

        RadioButton answer4question5Button = (RadioButton) findViewById(R.id.question5_answer4);
        boolean answer4question5 = answer4question5Button.isChecked();
        if (answer4question5) {
            score += 1;
        }

    //  Checks if the checkboxes with the correct answers were chosen

        CheckBox answer1question6Button = (CheckBox) findViewById(R.id.question6_answer1);
        boolean answer1question6 = answer1question6Button.isChecked();

        CheckBox answer2question6Button = (CheckBox) findViewById(R.id.question6_answer2);
        boolean answer2question6 = answer2question6Button.isChecked();

        CheckBox answer3question6Button = (CheckBox) findViewById(R.id.question6_answer3);
        boolean answer3question6 = answer3question6Button.isChecked();

        CheckBox answer4question6Button = (CheckBox) findViewById(R.id.question6_answer4);
        boolean answer4question6 = answer4question6Button.isChecked();

    // Checks that the correct combination was selected (only A and B selected together without any o
    // other answer is a correct choice any other combination is incorrect

        if (answer2question6 && answer1question6 && answer3question6 == false && answer4question6 == false) {
            score += 1;
        }

        RadioButton answer2question7Button = (RadioButton) findViewById(R.id.question7_answer2);
        boolean answer2question7 = answer2question7Button.isChecked();
              if (answer2question7) {
            score += 1;
        }

        TextView question8_answer = (TextView) findViewById(R.id.question8_answer);
        String answerQuestion8 = question8_answer.getText().toString();

        int compareValueQuestion8 = answerQuestion8.compareToIgnoreCase("Philae");
        if (compareValueQuestion8 == 0) {
            score += 1;
        }

        RadioButton answer1question9Button = (RadioButton) findViewById(R.id.question9_answer1);
        boolean answer1question9 = answer1question9Button.isChecked();
        if (answer1question9) {
            score += 1;
        }

        RadioButton answer3question10Button = (RadioButton) findViewById(R.id.question10_answer3);
        boolean answer3question10 = answer3question10Button.isChecked();
        if (answer3question10) {
            score += 1;
        }

    // Checking if every question has at least one answer, it this is not the case the test IfAllChecked
    // variable is increased by 1 for every unanswered question

        RadioGroup question1_radiogroup = (RadioGroup) findViewById(R.id.question1_radiogroup);
        int checkedQuestion1_radiogroup = question1_radiogroup.getCheckedRadioButtonId();

    //  If no radiobutton is checked the value returned is -1

        if (checkedQuestion1_radiogroup == -1) {
            testIfAllChecked += 1;
        }

        if (answerQuestion2.equals("")) {
            testIfAllChecked += 1;
        }

        RadioGroup question3_radiogroup = (RadioGroup) findViewById(R.id.question3_radiogroup);
        int checkedQuestion3_radiogroup = question1_radiogroup.getCheckedRadioButtonId();

        if (checkedQuestion3_radiogroup == -1) {
            testIfAllChecked += 1;
        }

        RadioGroup question4_radiogroup = (RadioGroup) findViewById(R.id.question4_radiogroup);
        int checkedQuestion4_radiogroup = question1_radiogroup.getCheckedRadioButtonId();

        if (checkedQuestion4_radiogroup == -1) {
            testIfAllChecked += 1;
        }

        RadioGroup question5_radiogroup = (RadioGroup) findViewById(R.id.question5_radiogroup);
        int checkedQuestion5_radiogroup = question5_radiogroup.getCheckedRadioButtonId();

        if (checkedQuestion5_radiogroup == -1) {
            testIfAllChecked += 1;
        }

        if (!answer1question6 && !answer2question6 & !answer3question6 & !answer4question6) {
            testIfAllChecked += 1;
        }

        RadioButton answer1question7Button = (RadioButton) findViewById(R.id.question7_answer1);
        boolean answer1question7 = answer1question7Button.isChecked();

        RadioButton answer3question7Button = (RadioButton) findViewById(R.id.question7_answer3);
        boolean answer3question7 = answer3question7Button.isChecked();

        if (!answer2question7 && !answer1question7 && !answer3question7) {
            testIfAllChecked += 1;
        }

        if (answerQuestion8.equals("")) {
            testIfAllChecked += 1;
        }

        RadioGroup question9_radiogroup = (RadioGroup) findViewById(R.id.question9_radiogroup);
        int checkedQuestion9_radiogroup = question1_radiogroup.getCheckedRadioButtonId();

        if (checkedQuestion9_radiogroup == -1) {
            testIfAllChecked += 1;
        }

        RadioGroup question10_radiogroup = (RadioGroup) findViewById(R.id.question10_radiogroup);
        int checkedQuestion10_radiogroup = question10_radiogroup.getCheckedRadioButtonId();

        if (checkedQuestion10_radiogroup == -1) {
            testIfAllChecked += 1;
        }
    //  If there are any unanswered question (testIfAllChecked more than 0 the user is informed with a
    //  toast that there is a number of questions still unanswered

        if (testIfAllChecked > 0) {
            Toast toast = Toast.makeText(getApplicationContext(), "Hi " + contestantName + ", you still have " + testIfAllChecked + " unanswered questions", Toast.LENGTH_LONG);
            toast.show();
            testIfAllChecked = 0;

    //  Setting the score back to 0 so that when the user submits the missing answers the summing process goes as expected
            score = 0;
        }

    //  If all the questions are answered no screen with the score is opened, remaining values are cleared,
    //  so if the users chooses to retry on the next screen the user is presented with a clean slate apart
    //  from the player name

        else {
            question1_radiogroup.clearCheck();
            question3_radiogroup.clearCheck();
            question4_radiogroup.clearCheck();
            question5_radiogroup.clearCheck();
            question9_radiogroup.clearCheck();
            question10_radiogroup.clearCheck();
            answer1question7Button.setChecked(false);
            answer2question7Button.setChecked(false);
            answer3question7Button.setChecked(false);
            answer1question6Button.setChecked(false);
            answer2question6Button.setChecked(false);
            answer3question6Button.setChecked(false);
            answer4question6Button.setChecked(false);
            question8_answer.setText("");
            question2_answer.setText("");

    //Starting the new screen and sending the score and player name to the new activity for future use
    
            Intent intent = new Intent(this, com.example.android.quizapp.results.class);
            intent.putExtra("score", score);
            intent.putExtra("contestantName", contestantName.toString());
            score = 0;
            startActivity(intent);
        }
    }
}