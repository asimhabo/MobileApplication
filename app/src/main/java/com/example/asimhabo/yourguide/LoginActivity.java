package com.example.merveerdem.yourguide;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.merveerdem.yourguide.DatabaseHelper;
import com.example.merveerdem.yourguide.R;
import com.example.merveerdem.yourguide.SignUp;

public class LoginActivity extends AppCompatActivity {

    DatabaseHelper helper;
    EditText pswd,usrusr;
    TextView sup,lin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        lin = (TextView) findViewById(R.id.lin);
        usrusr = (EditText) findViewById(R.id.usrusr);
        pswd = (EditText) findViewById(R.id.pswrdd);
        sup = (TextView) findViewById(R.id.sup);

        lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = usrusr.getText().toString();
                String pas = pswd.getText().toString();

                String password = helper.searchPass(str);
                if(pas.equals(password))
                {
                    Toast temp = Toast.makeText(LoginActivity.this , "You are logged in successfully", Toast.LENGTH_SHORT);
                    temp.show();
                }
                else {
                    Toast temp1 = Toast.makeText(LoginActivity.this , "Your password is wrong", Toast.LENGTH_SHORT);
                    temp1.show();
                }
            }
        });

        sup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(LoginActivity.this, SignUp.class);
                startActivity(it);
            }
        });
    }
}
