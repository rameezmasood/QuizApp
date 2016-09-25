package com.example.muhammad.quiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        //intializing actity_main views
        private RadioGroup mRadioGroupQ1;
        private boolean isRadioGroupQ1Scored;
        private RadioGroup mRadioGroupQ2;
        private boolean isRadioGroupQ2Scored;
        private RadioGroup mRadioGroupQ5;
        private boolean isRadioGroupQ5Scored;

        private EditText mEditTextQ3;
        private boolean isEditTextQ3Scored;
        private EditText mEditTextQ4;
        private boolean isEditTextQ4Scored;

        private CheckBox mCheckBoxQ6Opt1;
        private CheckBox mCheckBoxQ6Opt2;
        private CheckBox mCheckBoxQ6Opt3;
        private CheckBox mCheckBoxQ6Opt4;
        private boolean isCheckBoxScored;


        Context mContext;
        int score = 0;//scroe will on this variable
        private static final String LOG_TAG = "MainActivity";
        @Override

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            //fetching rootView of this activiet
            View rootView =  getWindow().getDecorView().getRootView();
            //Intializing RadioGroup
            //Becatus there is requirement  once user click any radio button it answer should not be change if they change otpoin
            initListeners(rootView);

        }
        //When user click on score button
        public void showScore(View view){


            //Manipulating EditText Option
            mEditTextQ3 = (EditText) findViewById(R.id.q3_edittext);
            mEditTextQ4 = (EditText) findViewById(R.id.q4_edittext);
            edittextQuestions();

            //Mainpulation  Checkbox Option
            mCheckBoxQ6Opt1 = (CheckBox) findViewById(R.id.chkbox_q6_opt1);
            mCheckBoxQ6Opt2 = (CheckBox) findViewById(R.id.chkbox_q6_opt2);
            mCheckBoxQ6Opt3 = (CheckBox) findViewById(R.id.chkbox_q6_opt3);
            mCheckBoxQ6Opt4 = (CheckBox) findViewById(R.id.chkbox_q6_opt4);
            checkboxQuestions();

            Toast.makeText(mContext, "You Score is " + score + " out of 6", Toast.LENGTH_SHORT).show();
            Log.v("MainActivity", "Score " + score);

        }

        private void initListeners(View view) {
            //Intializing radio group and set  on click listener
            mContext = view.getContext();
            isRadioGroupQ1Scored = false;
            isRadioGroupQ2Scored = false;
            isRadioGroupQ5Scored = false;

            isEditTextQ3Scored = false;
            isEditTextQ4Scored = false;

            isCheckBoxScored = false;


            mRadioGroupQ1 = (RadioGroup) view.findViewById(R.id.radiogrp_q1);
            mRadioGroupQ2 = (RadioGroup) view.findViewById(R.id.radiogrp_q2);
            mRadioGroupQ5 = (RadioGroup) view.findViewById(R.id.radiogrp_q5);

            //calculation score
            mRadioGroupQ1.setOnCheckedChangeListener(mRadioGroupListener);
            mRadioGroupQ2.setOnCheckedChangeListener(mRadioGroupListener);
            mRadioGroupQ5.setOnCheckedChangeListener(mRadioGroupListener);
        }
        //Matching EditText Question and calculating score
        private void edittextQuestions() {
            String edittextQ3 = mEditTextQ3.getText().toString().toLowerCase();
//        Log.d(LOG_TAG, "Question 3 " + edittextQ3);
            String edittextQ4 = mEditTextQ4.getText().toString().toLowerCase();
//        Log.d(LOG_TAG, "Question 3 " + edittextQ4);


            if (!isEditTextQ3Scored) {
                if (edittextQ3 != null && !edittextQ3.equals("")) {
                    String answer = getResources().getString(R.string.quiz_three_opt_1).toLowerCase();
                    if (edittextQ3.equals(answer)) {
                        score++;
                        isEditTextQ3Scored = true;
                        //Log.d(LOG_TAG, "EditText Q3 Score " + score);
                    }
                }
            }

            if (!isEditTextQ4Scored) {
                if (edittextQ3 != null && !edittextQ4.equals("")) {
                    String answer = getResources().getString(R.string.quiz_four_opt_1).toLowerCase();
                    if (edittextQ4.equals(answer)) {
                        score++;
                        isEditTextQ4Scored = true;
                        // Log.d(LOG_TAG, "EditText Q4 Score " + score);
                    }
                }
            }

        }
        //RadioGroup Onchange Listgern
        //Calculating score according to selected option
        private RadioGroup.OnCheckedChangeListener mRadioGroupListener = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radiobtn_q1_opt3:

                        if (!isRadioGroupQ1Scored) {
                            score++;
                            isRadioGroupQ1Scored = true;
                            //Log.v(LOG_TAG, "RadioButton Q1 Score " + score);
                        }
                        break;
                    case R.id.radiobtn_q2_opt3:
                        if (!isRadioGroupQ2Scored) {
                            score++;
                            isRadioGroupQ2Scored = true;
                            // Log.v(LOG_TAG, "RadioButton Q2 Score " + score);
                        }
                        break;
                    case R.id.radiobtn_q5_opt1:
                        if (!isRadioGroupQ5Scored) {
                            score++;
                            isRadioGroupQ5Scored = true;
                            //Log.v(LOG_TAG, "RadioButton Q5 Score " + score);
                        }
                        break;
                }
            }
        };


        /*
         * This question #6
         */
        private void checkboxQuestions() {
            if ((mCheckBoxQ6Opt1.isChecked() &&
                    mCheckBoxQ6Opt2.isChecked() &&
                    !mCheckBoxQ6Opt3.isChecked() &&
                    !mCheckBoxQ6Opt4.isChecked() &&
                    !isCheckBoxScored)) {
                score++;
                isCheckBoxScored = true;
                // Log.d(LOG_TAG, "CheckBox Q6 Score " + score);
            }
        }

}
