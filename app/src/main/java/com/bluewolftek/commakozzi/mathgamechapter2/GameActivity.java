package com.bluewolftek.commakozzi.mathgamechapter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    // Initialization -- Global Variables
    int correctAnswer;
    int answerGiven = 0;
    Button btnObjectChoice1;
    Button btnObjectChoice2;
    Button btnObjectChoice3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Initialization -- Variables
        int partA = 9;
        int partB = 9;
        correctAnswer = partA * partB;
        int wrongAnswer1 = correctAnswer - 1;
        int wrongAnswer2 = correctAnswer + 1;

        // Initialization -- Views
        TextView textObjectPartA = (TextView)findViewById(R.id.tvStartNumber);
        TextView textObjectPartB = (TextView)findViewById(R.id.tvEndNumber);
        btnObjectChoice1 = (Button)findViewById(R.id.btnFirstChoice);
        btnObjectChoice2 = (Button)findViewById(R.id.btnSecondChoice);
        btnObjectChoice3 = (Button)findViewById(R.id.btnThirdChoice);

        // Setup -- Views
        textObjectPartA.setText("" + partA);
        textObjectPartB.setText("" + partB);
        btnObjectChoice1.setText("" + correctAnswer);
        btnObjectChoice2.setText("" + wrongAnswer1);
        btnObjectChoice3.setText("" + wrongAnswer2);

        // Setup -- Button OnClickListeners
        btnObjectChoice1.setOnClickListener(this);
        btnObjectChoice2.setOnClickListener(this);
        btnObjectChoice3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnFirstChoice:
                answerGiven = Integer.parseInt("" + btnObjectChoice1.getText());
                checkAnswer(answerGiven);
                break;
            case R.id.btnSecondChoice:
                answerGiven = Integer.parseInt("" + btnObjectChoice2.getText());
                checkAnswer(answerGiven);
                break;
            case R.id.btnThirdChoice:
                answerGiven = Integer.parseInt("" + btnObjectChoice3.getText());
                checkAnswer(answerGiven);
                break;
        }
    }

    public void checkAnswer(int answer) {
        Toast wrongAnswerToast = Toast.makeText(getApplicationContext(), "You have chosen poorly", Toast.LENGTH_SHORT);
        Toast correctAnswerToast = Toast.makeText(getApplicationContext(), "You have chosen wisely!", Toast.LENGTH_SHORT);
        answer = answerGiven;
        if (answer == correctAnswer) {
            correctAnswerToast.show();
        } else {
            wrongAnswerToast.show();
        }
    }
}
