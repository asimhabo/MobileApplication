package com.example.merveerdem.yourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.merveerdem.yourguide.Contact;
import com.example.merveerdem.yourguide.DatabaseHelper;
import com.example.merveerdem.yourguide.MainActivity;
import com.example.merveerdem.yourguide.R;

public class SignUp extends AppCompatActivity {

    DatabaseHelper helper ;
    EditText name;
    EditText email;
    EditText pas2;
    EditText pas1;
    TextView sup1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name = findViewById(R.id.name);
        email = findViewById(R.id.mail);
        pas2 = findViewById(R.id.pas2);
        pas1 = findViewById(R.id.pas1);
        sup1 = findViewById(R.id.sup1);


        sup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namestr = name.getText().toString();
                String emailstr = email.getText().toString();
                String pas1str = pas1.getText().toString();
                String pas2str = pas2.getText().toString();

                if(!pas1str.equals(pas2str))
                {
                    Toast pass = Toast.makeText(SignUp.this , "Passwords don't match", Toast.LENGTH_SHORT);
                    pass.show();
                }
                else {

                    Contact c = new Contact();
                    c.setName(namestr);
                    c.setEmail(emailstr);
                    c.setPass(pas1str);

                    helper.insertContact(c);
                    Intent i = new Intent(SignUp.this, HomeActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}