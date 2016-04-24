package com.example.ayush.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.ayush.controllers.PaymentScreenController;

/**
 * Created by urkud on 4/23/2016.
 */
public class PaymentScreenActivity extends AppCompatActivity {

    private EditText username,CardNumber,CVV;
    private Button ConfirmButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Below code tells the java file, which xml file it is working with
        setContentView(R.layout.activity_expense_details);
        username = (EditText) findViewById(R.id.username);
        CardNumber = (EditText) findViewById(R.id.CardNumber);
        CVV = (EditText) findViewById(R.id.CVV);
        ConfirmButton = (Button) findViewById(R.id.ConfirmButton);
    }

    public void goToController(View view) {
        String user = username.getText().toString();
        String CN = CardNumber.getText().toString();
        String cv = CVV.getText().toString();

        new PaymentScreenController(this).execute(user, CN, cv);

        Intent paymentIntent = new Intent(PaymentScreenActivity.this, HomeScreenActivity.class);
        PaymentScreenActivity.this.startActivity(paymentIntent);

    }
}
//
//        expenseButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent addExpense = new Intent(ExpenseDetailsActivity.this, HomeScreenActivity.class);
//                ExpenseDetailsActivity.this.startActivity(addExpense);
//            }
//        });


