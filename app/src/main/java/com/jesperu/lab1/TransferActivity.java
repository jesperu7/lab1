package com.jesperu.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

public class TransferActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView errorMessage;
    private EditText inputAmount;
    private Button buttonPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);

        Intent intentBalance = getIntent();

        Spinner spinner = findViewById(R.id.friendsNames);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.friendList, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        errorMessage = findViewById(R.id.lbl_amount_check);
        inputAmount = findViewById(R.id.txt_amount);
        buttonPay = findViewById(R.id.btn_pay);

        inputAmount.addTextChangedListener(amountWatcher);
    }

    private TextWatcher amountWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            int balance = getIntent().getIntExtra(MainActivity.EXTRA_NUMBER, 0);
            TextView amount = (TextView) findViewById(R.id.txt_amount);
            String number = amount.getText().toString().trim();
            int num = Integer.parseInt(number);
            if (number.isEmpty() && num < balance){
                errorMessage.setVisibility(View.VISIBLE);
            }
            if (num == 0 && num < balance) {
                errorMessage.setVisibility(View.VISIBLE);
            }

            buttonPay.setEnabled(num > 0);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
