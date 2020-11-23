package com.example.firapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SigninActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        EditText name = (EditText)findViewById(R.id.username);
        EditText pwd = (EditText)findViewById(R.id.userpwd);
        EditText email = (EditText)findViewById(R.id.useremail);

        TextView textView = (TextView)findViewById(R.id.signup);
        TextView forgotView = (TextView)findViewById(R.id.forgot);

        Button signinBtn = (Button)findViewById(R.id.signin_btn);
//        signinBtn.setBackground(color.WHITE);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("dfd", String.valueOf(textView));
                Intent intent = new Intent(SigninActivity.this,SignupActivity.class);

                startActivity(intent);
                finish();
            }
        });

        forgotView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SigninActivity.this, ForgotActivity.class);

                startActivity(intent);
                finish();
            }
        });

        signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("dfdf", String.valueOf(signinBtn));

//                validation test
                if (name.getText().toString().isEmpty() || pwd.getText().toString().isEmpty()|| email.getText().toString().isEmpty()){
//                    Toast.makeText(SigninActivity.this, “Do globo ao traquinas, é Biscoito!”, Toast.LENGTH_LONG).show();

                    Toast.makeText(SigninActivity.this,"please insert information",Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(SigninActivity.this,HomeActivity.class);
                    startActivity(intent);
                    finish();

                }


            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(SigninActivity.this,SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}