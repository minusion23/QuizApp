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
        int score = getIntent().getIntExtra("score", 0);
        String contestantName = getIntent().getStringExtra("contestantName");
        String message = "";

        TextView quiz_resultsTextView = (TextView) findViewById(R.id.quiz_results);
        String quiz_resultsText = quiz_resultsTextView.getText().toString();

        if (score < 4) {
            quiz_resultsTextView.setText("You have scored " + score + " points. Nicely done " + contestantName + "! If you want you can retry the test or send your score to a friend");
            message += ""+ contestantName + " has scored " + score + " points in the Space Quiz !";
        }
        if (3 < score && score < 6) {
            quiz_resultsTextView.setText("You have scored " + score + " points. Great job " + contestantName + "! If you want you can retry the test or send your score to a friend");
            message +=  ""+ contestantName + " has scored " + score + " points in the Space Quiz !";
        }

        if (score >= 6) {
            quiz_resultsTextView.setText("You have scored " + score + " points. This is fantastic " + contestantName + "! If you want you can retry the test or send your score to a friend");
            message += ""+ contestantName + " has scored " + score + " points in the Space Quiz !";
        }
    }




    public void retry (View view) {
                finish();
    }

//    public void send_to_a_friend (String contestantName, int score) {
//        String mail = contestantName + " has scored " + score + " points in the Space Quiz !";
//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
//        intent.putExtra(Intent.EXTRA_SUBJECT, "My Space quiz App score is " + score);
//        intent.putExtra(Intent.EXTRA_TEXT, "Hi There");
//        if (intent.resolveActivity(getPackageManager()) != null)
//        startActivity(intent);}

    public void send_to_a_friend (View view ) {
        int score = getIntent().getIntExtra("score", 0);
        String contestantName = getIntent().getStringExtra("contestantName");
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto: ")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "My Space quiz App score is " + score);
        intent.putExtra(Intent.EXTRA_TEXT, "Hi, " + contestantName + "has scored " + score + " points in the Space Quiz app !!");
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);}

    /**
 * publicn
 *
 * Created by Szymon on 06.02.2018.
 */



}
