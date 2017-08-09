package com.couchsurfing.couchsurfingquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class End extends AppCompatActivity {
    // sums the values of all answer values
    public int final_score = Question1.q1 + Question2.q2 + Question3.q3 + Question4.q4 + Question5.q5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        TextView name = (TextView) findViewById(R.id.lbl_name);
        name.setText(MainActivity.name);

        TextView score = (TextView) findViewById(R.id.score);
        score.setText(R.string.score);

        TextView lbl_txt_score = (TextView) findViewById(R.id.txt_lbl_score);
        lbl_txt_score.setText(String.valueOf(final_score) + " out of 5");

        Button reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  resets all answer values
                Question1.q1 = 0;
                Question2.q2 = 0;
                Question3.q3 = 0;
                Question4.q4 = 0;
                Question5.q5 = 0;

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        Toast.makeText(getApplicationContext(), String.valueOf(final_score)+" out of 5, final score", Toast.LENGTH_SHORT).show();
    }
}
