package com.example.tema1workoutplan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {



    Button btnSignIn, btnCreate;
    TextInputEditText tietEmail, tietUsername, tietPassword, tietDate;

    Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnSignIn = findViewById(R.id.btn_sign_in);
        btnCreate = findViewById(R.id.btn_create);

        tietEmail = findViewById(R.id.tiet_add_new_email);
        tietUsername = findViewById(R.id.tiet_add_new_username);
        tietPassword = findViewById(R.id.tiet_add_new_password);
        tietDate = findViewById(R.id.tiet_add_date);
        person = new Person();

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValid()) {
                    person.setEmail(tietEmail.getText().toString());
                    person.setUsername(tietUsername.getText().toString());
                    person.setPassword(tietPassword.getText().toString());
                    person.setDate(tietDate.getText().toString());

                    Toast.makeText(SignUpActivity.this, person.toString(), Toast.LENGTH_LONG).show();

                    Bundle bundle = new Bundle();
                    bundle.putParcelable("OK", person);

                    Intent intent = new Intent();
                    intent.putExtra("PersonBundle",bundle);
                    setResult(RESULT_OK, intent);
                    finish();

                }
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), SignInActivity.class);
                startActivity(intent2);
            }
        });

    }

    private boolean isValid(){
        if(tietEmail.toString().isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Va rog completati email-ul", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(tietEmail.toString().isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Va rog completati username-ul", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(tietPassword.toString().isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Va rog completati password-ul", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(tietDate.toString().isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Va rog completati data nasterii", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(!isEmailValid(tietEmail.getText().toString())) {
            Toast.makeText(SignUpActivity.this, "Emailul nu respecta formatul", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    public boolean isEmailValid(String email) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
    }

}