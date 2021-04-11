package com.nurayim.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText themeEditText;
    private EditText commentEditTet;
    Button btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {

        emailEditText = findViewById(R.id.First_edit_text);
        themeEditText = findViewById(R.id.second_edit_text);
        commentEditTet = findViewById(R.id.third_edit_text);
        btn = findViewById(R.id.btn);
        checkMethod();
    }

    private void checkMethod() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] email = {emailEditText.getText().toString()};
                String theme = themeEditText.getText().toString();
                String comment = commentEditTet.getText().toString();

                if (TextUtils.isEmpty(emailEditText.getText()) && TextUtils.isEmpty(theme) && TextUtils.isEmpty(comment)){
                    Log.d("TAG", "onClick:   empty" + email);
                    Toast.makeText(MainActivity.this,"Заполните поля обязательно",Toast.LENGTH_LONG).show();
                }else {
                    Log.d("TAG", "onClick:  test" + email+ theme +comment);

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_TEXT,comment);
                    intent.putExtra(Intent.EXTRA_TEXT,theme);
                    intent.putExtra(Intent.EXTRA_EMAIL,email);
                    intent.setType("text/html");
                    try {
                        startActivity(Intent.createChooser(intent,"iuytre"));
                    }catch (ActivityNotFoundException e){
                        Log.d("TAG", "onClick: " + e.getMessage());
                    }
                }

            }
        });

    }
}