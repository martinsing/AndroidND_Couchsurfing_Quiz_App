package com.couchsurfing.couchsurfingquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Question2 extends AppCompatActivity {
    private final String LOG_TAG = "Question2";
    // value of the answer
    public static int q2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        // correct responses
        final CheckBox checkBox1 = (CheckBox) findViewById(R.id.response1);
        final CheckBox checkBox3 = (CheckBox) findViewById(R.id.response3);
        final CheckBox checkBox4 = (CheckBox) findViewById(R.id.response4);
        final CheckBox checkBox6 = (CheckBox) findViewById(R.id.response6);
        final CheckBox checkBox7 = (CheckBox) findViewById(R.id.response7);
        // wrong responses
        final CheckBox checkBox2 = (CheckBox) findViewById(R.id.response2);
        final CheckBox checkBox5 = (CheckBox) findViewById(R.id.response5);
        final CheckBox checkBox8 = (CheckBox) findViewById(R.id.response8);

        Button submit = (Button) findViewById(R.id.submitq2);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox2.isChecked() ||
                        checkBox5.isChecked() ||
                        checkBox8.isChecked()) {
                    q2 = 0;
                    Toast.makeText(getApplicationContext(), R.string.wrong_answer_2, Toast.LENGTH_SHORT).show();
                } else {
                    if (checkBox1.isChecked() &&
                            checkBox3.isChecked() &&
                            checkBox4.isChecked() &&
                            checkBox6.isChecked() &&
                            checkBox7.isChecked()) {
                        q2 = 1;
                        Toast.makeText(getApplicationContext(), R.string.right_answer_2, Toast.LENGTH_SHORT).show();
                    } else {
                        q2 = 0;
                        Toast.makeText(getApplicationContext(), R.string.wrong_answer_2, Toast.LENGTH_SHORT).show();
                    }
                }
                Intent intent = new Intent(getApplicationContext(), Question3.class);
                startActivity(intent);
            }
        });
    }
}
