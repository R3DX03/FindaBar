package com.example.marlonscheer.findabar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText Username;
    private EditText Password;
    private Button Login;
    String login_name,login_pass;
    private Button register;


//test


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = (EditText) findViewById(R.id.etUsername);
        Password = (EditText) findViewById(R.id.etPassword);
        Login = (Button) findViewById(R.id.btnLogin);
        register = (Button) findViewById(R.id.buttonreglog);


    }

    public void userReg (View view){

        //OnClick von userReg
        startActivity(new Intent(this, RegisterActivity.class ));

    }

    public void userLogin (View view){
//OnClick von userLogin

        login_name = Username.getText().toString();
        login_pass = Password.getText().toString();
        String method = "login";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,login_name,login_pass) ;





    }

}

