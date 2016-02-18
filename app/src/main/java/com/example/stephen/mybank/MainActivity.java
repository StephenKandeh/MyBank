package com.example.stephen.mybank;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText Input_Number;
    Button Withdraw;
    Button Deposit;
    TextView Money_in_Bank;
    TextView Balance_Display;
    BankAccount myAccount;
    private static final String M = "MainActive";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        Money_in_Bank = (TextView) findViewById(R.id.mib);
        Withdraw = (Button) findViewById(R.id.w);
        Deposit = (Button) findViewById(R.id.d);
        Input_Number=(EditText)findViewById(R.id.in);
        Balance_Display = (TextView) findViewById(R.id.B);

        Log.d(M,"The overdraft fee of my bank is currently "+ BankAccount.odf());
        myAccount = new BankAccount();
        Balance_Display.setText("" + myAccount.BankBalance());


        View.OnClickListener userInputD = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String get = Input_Number.getText().toString();
                myAccount.deposit(Double.parseDouble(get));
                Balance_Display.setText(""+ myAccount.BankBalance());

            }
        };



        Deposit.setOnClickListener(userInputD);


        View.OnClickListener userInputW = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String get = Input_Number.getText().toString();
                myAccount.withdraw(Double.parseDouble(get));
                Balance_Display.setText(""+myAccount.BankBalance());

            }
        };

        Withdraw.setOnClickListener(userInputW);


        double v = BankAccount.odf();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
