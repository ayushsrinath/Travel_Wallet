package com.example.ayush.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ayush.controllers.LoginController;

public class LoginActivity extends AppCompatActivity {



    private EditText username;
    private EditText password;
    private Button loginBtn;

    //@InjectView(R.id.email) EditText email;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Below line tells the java file, which xml file it is working with
        setContentView(R.layout.activity_login);

        //email id and password entered by user are captured here
        username = (EditText) findViewById(R.id.etUserName);
        password = (EditText) findViewById(R.id.etPassword);
        loginBtn = (Button) findViewById(R.id.btLogin);

        //call loginController method on click of login button
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameStr = username.getText().toString();
                String passwordStr = password.getText().toString();
                invokeLoginController(usernameStr, passwordStr);
            }
        });





        final EditText etUserName = (EditText) findViewById(R.id.etUserName);
        etUserName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                String inputUserName = v.getText().toString();
                if(inputUserName == "travelwallet@gmail.com"){
                    Intent homeIntent = new Intent(LoginActivity.this, HomeScreenActivity.class);
                    LoginActivity.this.startActivity(homeIntent);
                }
                return false;
            }
        });
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button btLogin = (Button) findViewById(R.id.btLogin);
        final TextView RegisterLink = (TextView) findViewById(R.id.tvRegisterHere);

        RegisterLink.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });

        /*btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent homeIntent = new Intent(LoginActivity.this, HomeScreenActivity.class);
                LoginActivity.this.startActivity(homeIntent);
            }
        });*/

    }

    //invoke the LoginController background from here
    public void invokeLoginController(String uname, String pwd) {
        new LoginController(this).execute(uname, pwd);

        Intent homeIntent = new Intent(LoginActivity.this, HomeScreenActivity.class);
        LoginActivity.this.startActivity(homeIntent);
    }


    @Override
    public void onBackPressed(){

    }
}
