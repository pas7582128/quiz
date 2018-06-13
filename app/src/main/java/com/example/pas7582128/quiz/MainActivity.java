package com.example.pas7582128.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;
    private static final String KEY_INDEX = "index";
    private Question[] mQuestionBank=new Question[]{
            new Question(R.string.question_australia,
                    true),
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast,
                    false),
            new Question(R.string.question_africa,
                    false),new Question(R.string.question_americas,
            true),
            new Question(R.string.question_asia, true),
    };
    private int mCurrentIndex=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null){
            mCurrentIndex=savedInstanceState.getInt(KEY_INDEX,0);
        }
        mTrueButton=findViewById(R.id.true_button);
        mFalseButton=findViewById(R.id.false_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
            checkAnswer(true);
            }
        });
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
                checkAnswer(false);
            }
        });
        mQuestionTextView=(TextView) findViewById(R.id.question_textview);
        mNextButton=findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mCurrentIndex==mQuestionBank.length-1){
                    mCurrentIndex=0;
                }
                else{
                    mCurrentIndex=mCurrentIndex+1;
                }
                upDateQuestion();
            }

        });
        upDateQuestion();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("AA","onSaveInstanceState");
        outState.putInt(KEY_INDEX,mCurrentIndex);
    }

    private void upDateQuestion(){
        int question=mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }
    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue=mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageResId;
        if(answerIsTrue==userPressedTrue){
            messageResId=R.string.correct_toast;
        }
        else{
            messageResId=R.string.incorrect_toast;
        }
        Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).show();
    }
}
