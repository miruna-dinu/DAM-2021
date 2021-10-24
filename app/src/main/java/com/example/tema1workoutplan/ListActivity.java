package com.example.tema1workoutplan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {

    private static final int SIGN_UP_REQUEST_CODE = 100;
    private Button btnSI, btnSU;
    private TextView tw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        btnSI = findViewById(R.id.btnSignInMain);
        btnSU = findViewById(R.id.btnSignUpMain);
        tw  = findViewById(R.id.textView);

        btnSI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });

        btnSU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, SignUpActivity.class);
                startActivityForResult(intent, SIGN_UP_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SIGN_UP_REQUEST_CODE) {
            if(resultCode == RESULT_OK) {
                if(data != null) {
                    Bundle bundle = data.getBundleExtra("PersoanaBundle");
                    Person person = bundle.getParcelable("OK");
                    tw.setText(person.toString());
                }
            }
        }
    }
}