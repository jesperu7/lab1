package com.jesperu.lab1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final int RESULT_CODE = 0;
    public static final String BALANCE = "balance";
    private Button btn_transfer;
    private Button btn_transactions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        int randNum = rand.nextInt(20)+91;
        TextView myText = (TextView) findViewById(R.id.lbl_rand);
        String myString = String.valueOf(randNum);
        myText.setText(myString);

        btn_transfer = (Button) findViewById(R.id.btn_transfer);
        btn_transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTransferActivity();
            }
        });

        btn_transactions = (Button) findViewById(R.id.btn_transactions);
        btn_transactions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTransactionsActivity();
            }
        });



    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == RESULT_CODE){
            if (resultCode == Activity.RESULT_OK){

            }
        }

    }

    public void openTransferActivity() {
        TextView textView = findViewById(R.id.lbl_rand);
        String number = textView.getText().toString();

        Intent intent = new Intent(this, TransferActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(BALANCE, number);

        intent.replaceExtras(bundle);
        startActivityForResult(intent, RESULT_CODE);
    }

    public void openTransactionsActivity() {
        Intent intent = new Intent(this, TransactionsActivity.class);
        startActivity(intent);
    }

}
