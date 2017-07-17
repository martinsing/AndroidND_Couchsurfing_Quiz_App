package com.couchsurfing.couchsurfingquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Question1 extends AppCompatActivity {
    private final String LOG_TAG = "Question1";
    // All initial values of responses is set at 2
    private int response = 2;
    // value of the answer
    public static int q1 = 0;

    // finds the value of the radio button when clicked
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.yes:
                if (checked)
                    response = 1;
                Log.i(LOG_TAG, "reponse: " + response);
                break;
            case R.id.no:
                if (checked)
                    response = 0;
                Log.i(LOG_TAG, "reponse: " + response);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Will recycle this layout to reduce the number of resources
        setContentView(R.layout.yes_or_no);

        TextView textView = (TextView) findViewById(R.id.question);
        textView.setText(R.string.question_1);

        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (response == 0) {
                    //  right answer makes the value increase
                    q1 = 1;
                    Toast.makeText(getApplicationContext(), R.string.right_answer_1, Toast.LENGTH_SHORT).show();
                } else {
                    q1 = 0;
                    Toast.makeText(getApplicationContext(), R.string.wrong_answer_1, Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(getApplicationContext(), Question2.class);
                startActivity(intent);
            }
        });
    }
}
