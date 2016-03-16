package com.example.rahishadhungana.fyp;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Register extends AppCompatActivity implements View.OnClickListener {

    Button bRegister;
    EditText etName, etUsername, etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        etName = (EditText) findViewById(R.id.etName);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bRegister:

                if (etName.getText().toString().equals("") || etUsername.getText().toString().equals("") || etPassword.getText().toString().equals("")) {
                    Toast.makeText(Register.this, "Fill in all the fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    String name, username, password;

                    Toast.makeText(Register.this, "User registered!!!", Toast.LENGTH_LONG).show();
                    name = etName.getText().toString();
                    Log.e("AndroidName", name);
                    username = etUsername.getText().toString();
                    password = etPassword.getText().toString();
                    String method = "register";
                    BackgroundTask backgroundTask = new BackgroundTask(this);
                    backgroundTask.execute(method, name, username, password);
                    finish();
                }

                break;
        }


    }


}
