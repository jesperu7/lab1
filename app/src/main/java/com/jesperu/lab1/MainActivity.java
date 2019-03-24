package com.jesperu.lab1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final int RESULT_CODE = 0;
    public static String BALANCE = "balance";
    public static final String TRANTIME = "timeOfTransaction";
    public static final String TRANRECIPIENT = "recipient";
    public static final String UPDATEBALANCE = "newBalance";
    public static final String TRANAMOUNT = "amountTransfered";
    private Button btn_transfer;
    private Button btn_transactions;

    private ArrayList<String> timeOfTransfer;
    private ArrayList<String> reciever;
    private ArrayList<Integer> amountTransfered;
    private ArrayList<Integer> currentBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        int randNum = rand.nextInt(20)+91;
        TextView myText = (TextView) findViewById(R.id.lbl_rand);
        BALANCE = String.valueOf(randNum);
        myText.setText(BALANCE);

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
                Bundle bundle = data.getExtras();
                String temp1 = bundle.get(TransferActivity.AMOUNT).toString();
                String temp2 = bundle.get(TransferActivity.RECIPIENT).toString();
                this.timeOfTransfer.add(String.valueOf(android.text.format.DateFormat.format("HH::mm::ss", new java.util.Date())));
                this.reciever.add(temp2);
                this.amountTransfered.add(Integer.parseInt(temp1));
                int tempBal = (Integer.parseInt(BALANCE) - Integer.parseInt(temp1));
                this.BALANCE = Integer.toString(tempBal);
                this.currentBalance.add(Integer.parseInt(BALANCE));

                TextView myBalance = findViewById(R.id.lbl_rand);
                myBalance.setText(BALANCE);
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
        Bundle b = new Bundle();

        intent.putStringArrayListExtra("time_array", timeOfTransfer);
        intent.putStringArrayListExtra("recipient_array", reciever);
        intent.putIntegerArrayListExtra("updated_balance", currentBalance);
        intent.putIntegerArrayListExtra("amount_transfered", amountTransfered);
        intent.putExtras(b);
        startActivity(intent);

    }


}
