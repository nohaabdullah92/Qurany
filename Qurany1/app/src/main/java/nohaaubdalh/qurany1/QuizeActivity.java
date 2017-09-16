package nohaaubdalh.qurany1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizeActivity extends AppCompatActivity {
    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private  Button BACK;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quize);

        mScoreView = (TextView)findViewById(R.id.score2);
        mQuestionView = (TextView)findViewById(R.id.questions);
        mButtonChoice1 = (Button)findViewById(R.id.choise1);
        mButtonChoice2 = (Button)findViewById(R.id.choise2);
        mButtonChoice3 = (Button)findViewById(R.id.choise3);
       BACK=(Button)findViewById(R.id.choise4);


        updateQuestion();

        //Start of Button Listener for Button1
        mButtonChoice1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoice1.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optiona
                    Toast.makeText(QuizeActivity.this, "إجابتك صحيحة", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(QuizeActivity.this, "إجابتك خاطئة", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button1

        //Start of Button Listener for Button2
        mButtonChoice2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoice2.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optiona
                    Toast.makeText(QuizeActivity.this, "إجابتك صحيحه", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(QuizeActivity.this, "إجابتك خاطئة", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button2


        //Start of Button Listener for Button3
        mButtonChoice3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoice3.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optiona
                    Toast.makeText(QuizeActivity.this, "إجابتك صحيحة", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(QuizeActivity.this, "إجابتك خاطئة", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button3

        BACK.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(QuizeActivity.this,MainActivity1.class);
                startActivity(intent);


            }
        });




    }

    private void updateQuestion(){
        mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        mButtonChoice1.setText(mQuestionLibrary.getChoise1(mQuestionNumber));
        mButtonChoice2.setText(mQuestionLibrary.getChoise2(mQuestionNumber));
        mButtonChoice3.setText(mQuestionLibrary.getChoise3(mQuestionNumber));

        mAnswer = mQuestionLibrary.getCorectAnswer(mQuestionNumber);
        mQuestionNumber++;
    }


    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }
    }

