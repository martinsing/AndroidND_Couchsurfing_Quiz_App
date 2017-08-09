package com.couchsurfing.couchsurfingquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Question4 extends AppCompatActivity {
    private final String LOG_TAG = "Question3";
    //    All initial values of responses is set at 2
    private int response = 2;
    // value of the answer
    public static int q4 = 0;

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
        textView.setText(R.string.question_4);

        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (response == 1) {
                    //  right answer makes the value increase
                    q4 = 1;
                    Toast.makeText(getApplicationContext(), R.string.right_answer_4, Toast.LENGTH_SHORT).show();
                } else {
                    q4 = 0;
                    Toast.makeText(getApplicationContext(), R.string.wrong_answer_4, Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(getApplicationContext(), Question5.class);
                startActivity(intent);
            }
        });
    }
}
