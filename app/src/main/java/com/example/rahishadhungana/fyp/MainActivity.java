package com.example.rahishadhungana.fyp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUsername;
    EditText etPassword;
    TextView tvRegister;
    Button bLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        tvRegister = (TextView) findViewById(R.id.tvRegister);
        bLogin = (Button) findViewById(R.id.bLogin);

        bLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.tvRegister:
                Intent registerIntent = new Intent(MainActivity.this, Register.class);
                startActivity(registerIntent);
                break;
            case R.id.bLogin:
                Log.e("OVER_HERE", "I WAS CLICKED");
                if (etUsername.getText().toString().equals("") || etPassword.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Fill in all the fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    String method = "login";
                    String username = etUsername.getText().toString();
                    String password = etPassword.getText().toString();
                    BackgroundTask backgroundTask = new BackgroundTask(this);
                    backgroundTask.execute(method, username, password);


//                    Toast.makeText(MainActivity.this, "User registered!!!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
