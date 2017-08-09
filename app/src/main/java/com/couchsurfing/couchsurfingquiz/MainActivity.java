package com.couchsurfing.couchsurfingquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String LOG_TAG = "MainActivity";
    private Button start;
    private EditText editText = null;
    public static String name = null;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.name);

        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = editText.getText().toString().trim();
                if(name.matches("")) {
                    Toast.makeText(getApplicationContext(), "Need a name", Toast.LENGTH_SHORT).show();
                }else{
                    Log.i(LOG_TAG, "name is:" + name + ".");
                    Intent intent = new Intent(view.getContext(), Question1.class);
                    startActivity(intent);
                }
            }
        });
    }
}
