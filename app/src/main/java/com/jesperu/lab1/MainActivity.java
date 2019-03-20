package com.jesperu.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_NUMBER = "com.jesperu.lab1.EXTRA_NUMBER";
    private Button btn_transfer;
    private Button btn_transactions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        Random rand = new Random();
        int randNum = rand.nextInt(20)+91;
        TextView myText = (TextView) findViewById(R.id.lbl_rand);
        String myString = String.valueOf(randNum);
        myText.setText(myString);

    }

    public void openTransferActivity() {
        TextView textView = (TextView) findViewById(R.id.lbl_rand);
        int number = Integer.parseInt(textView.getText().toString());

        Intent intent = new Intent(this, TransferActivity.class);
        intent.putExtra(EXTRA_NUMBER, number);
        startActivity(intent);
    }

    public void openTransactionsActivity() {
        Intent intent = new Intent(this, TransactionsActivity.class);
        startActivity(intent);
    }

}
