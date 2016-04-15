package com.example.ayush.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Below code tells the java file, which xml file it is working with
        setContentView(R.layout.activity_home_screen);

        final EditText etUserName = (EditText) findViewById(R.id.etUserName);
       // final EditText etAge = (EditText) findViewById(R.id.etAge);
        final TextView tvWelcomeMsg = (TextView) findViewById(R.id.tvWelcomeMsg);
        final Button btExchangeCurrency = (Button) findViewById(R.id.btExchangeCurrency);
        final Button btWallet = (Button) findViewById(R.id.btWallet);
        final Button btEditProfile = (Button) findViewById(R.id.btEditProfile);

        btEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(HomeScreenActivity.this, RegisterActivity.class);
                HomeScreenActivity.this.startActivity(registerIntent);
            }
        });

        btWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent walletIntent = new Intent(HomeScreenActivity.this, Nav_WalletActivity.class);
                HomeScreenActivity.this.startActivity(walletIntent);
            }
        });

        btExchangeCurrency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent drawerIntent = new Intent(HomeScreenActivity.this, ExchangeCurrencyActivity.class);
                HomeScreenActivity.this.startActivity(drawerIntent);
            }
        });
    }
}
