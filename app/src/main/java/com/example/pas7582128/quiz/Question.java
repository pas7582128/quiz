package com.example.pas7582128.quiz;

/**
 * Created by pas7582128 on 11/6/18.
 */

public class Question {
    private int mTextResId;
    private boolean mAnswerTrue;
    private Question(int textResId,boolean answerTrue){
        mTextResId=textResId;
        mAnswerTrue=answerTrue;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }
}
