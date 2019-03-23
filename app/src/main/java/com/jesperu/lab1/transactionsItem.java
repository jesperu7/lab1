package com.jesperu.lab1;

public class transactionsItem {
    private String mTime;
    private String mRecipient;
    private String mAmount;
    private String mBalance;

    public transactionsItem(String time, String recipient, String amount, String balance){
        mTime = time;
        mRecipient = recipient;
        mAmount = amount;
        mBalance = balance;
    }

    public String getTime(){
        return mTime;
    }

    public String getRecipient() {
        return mRecipient;
    }

    public String getAmount(){
        return mAmount;
    }

    public String getBalance() {
        return mBalance;
    }
}
