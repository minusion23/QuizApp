package com.example.android.quizapp;

    import android.content.Intent;
    import android.net.Uri;
    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;
    import android.util.Log;
    import android.view.View;
    import android.widget.CheckBox;
    import android.widget.EditText;
    import android.widget.TextView;
    import android.widget.Toast;
    import org.w3c.dom.Text;


public class results extends AppCompatActivity {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
//        loading useful variables from the main activity that were committed to be sent
        int score = getIntent().getIntExtra("score", 0);
        String contestantName = getIntent().getStringExtra("contestantName");

//    Depending on the score the user received a different message once the screen loads
        TextView quiz_resultsTextView = (TextView) findViewById(R.id.quiz_results);
        String quiz_resultsText = quiz_resultsTextView.getText().toString();

        if (score < 4) {
            quiz_resultsTextView.setText(getString(R.string.scoretextPart1) + score + getString(R.string.scoreMessagepart2) + contestantName + getString(R.string.scoreMessagepart3));
        }
        if (3 < score && score < 6) {
            quiz_resultsTextView.setText(getString(R.string.scoretextPart1) + score + getString(R.string.scoreMessagepart2) + contestantName + getString(R.string.scoreMessagepart3));
                }
        if (score >= 6) {
            quiz_resultsTextView.setText(getString(R.string.scoretextPart1) + score + getString(R.string.scoreMessagepart2)  + contestantName + getString(R.string.scoreMessagepart3));
        }
    }
//Once the user clicks retry, activiy closes and the user goes back to the test to take it again
//    with all the values cleared, apart from the name
    public void retry (View view) {
                finish();
    }
//    Score details are avaialabe to be sent via e-mail:
    public void send_to_a_friend (View view ) {
        int score = getIntent().getIntExtra("score", 0);
        String contestantName = getIntent().getStringExtra("contestantName");
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto: ")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "My Space quiz App score is " + score);
        intent.putExtra(Intent.EXTRA_TEXT, "Hi, " + contestantName + "has scored " + score + " points in the Space Quiz app !!");
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);}

}
