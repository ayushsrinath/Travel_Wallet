package com.example.ayush.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ayush.controllers.LoginActivityController;

public class RegisterActivity extends AppCompatActivity {


    private EditText etFirstName,etLastName,etPhoneNumber,etEmailid,etAddress,etPassword;
    private Button btRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Below code tells the java file, which xml file it is working with
        setContentView(R.layout.activity_register);

        //final EditText etAge = (EditText) findViewById(R.id.etAge);
         etFirstName = (EditText) findViewById(R.id.etFirstName);
         etLastName = (EditText) findViewById(R.id.etLastName);
         etPhoneNumber = (EditText) findViewById(R.id.etPhoneNumber);
         etEmailid = (EditText) findViewById(R.id.etEmailid);
         etAddress = (EditText) findViewById(R.id.etAddress);
         etPassword = (EditText) findViewById(R.id.etPassword);
         btRegister = (Button) findViewById(R.id.btRegister);

        System.out.println("##############Going to COntroller....");

        //btRegister.setOnClickListener();
        //new LoginActivityController();
    }

    public void goToController(View view){
        String firstname = etFirstName.getText().toString();
        String lastname = etLastName.getText().toString();
        String phonenumber = etPhoneNumber.getText().toString();
        String emailid = etEmailid.getText().toString();
        String address = etAddress.getText().toString();
        String password = etPassword.getText().toString();

        new LoginActivityController(this).execute(firstname,lastname,phonenumber,emailid,address,password);

        Intent loginIntent = new Intent(RegisterActivity.this,LoginActivity.class);
        RegisterActivity.this.startActivity(loginIntent);

    }
}
