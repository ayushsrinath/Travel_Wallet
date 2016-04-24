package com.example.ayush.loginregister;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;



import com.example.ayush.controllers.ExpenseDetailsController;


/**
 * Created by urkud on 4/23/2016.
 */
public class ExpenseDetailsActivity extends AppCompatActivity {

    private EditText expenseAmount,dateOfPurchase,location;
    private Spinner category;
    private Button expenseButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Below code tells the java file, which xml file it is working with
        setContentView(R.layout.activity_expense_details);
         expenseAmount = (EditText) findViewById(R.id.ExpenseAmountText);
         dateOfPurchase = (EditText) findViewById(R.id.DateOfPurchaseText);
         category = (Spinner) findViewById(R.id.CategoryOfPurchaseSpinner);
        location = (EditText) findViewById(R.id.LocationOfPurchaseText);
        expenseButton = (Button) findViewById(R.id.EditExpenseButton);
    }

    public void goToController(View view) {
        String expenseAmt = expenseAmount.getText().toString();
        String dop = dateOfPurchase.getText().toString();
        String cat = category.getTransitionName().toString();
        String loc = location.getText().toString();

        new ExpenseDetailsController(this).execute(expenseAmt, dop, cat, loc);

        Intent homeIntent = new Intent(ExpenseDetailsActivity.this, HomeScreenActivity.class);
        ExpenseDetailsActivity.this.startActivity(homeIntent);

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








