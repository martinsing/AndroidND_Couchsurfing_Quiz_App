package com.couchsurfing.couchsurfingquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Question5 extends AppCompatActivity {

    private final String LOG_TAG = "Question5";
    private EditText editText = null;
    private String response;
    // value of the answer
    public static int q5 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);

        editText = (EditText) findViewById(R.id.response1);
        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                response = editText.getText().toString().trim();
                if (response.matches(MainActivity.name)) {
                    q5 = 1;
                    Toast.makeText(getApplicationContext(), R.string.right_answer_5, Toast.LENGTH_SHORT).show();
                } else {
                    q5 = 0;
                    Toast.makeText(getApplicationContext(), R.string.wrong_answer_5, Toast.LENGTH_SHORT).show();
                }
                Log.i(LOG_TAG, "name is:" + response + ".");
                Intent intent = new Intent(getApplicationContext(), End.class);
                startActivity(intent);
            }
        });
    }
}