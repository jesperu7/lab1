package com.jesperu.lab1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TransactionsAdapter extends RecyclerView.Adapter<TransactionsAdapter.TransactionViewHolder> {

    public static class TransactionViewHolder extends RecyclerView.ViewHolder {
        public TextView timeTextView;
        public TextView recipientTextView;
        public TextView amountTextView;
        public TextView balanceTextView;



        public TransactionViewHolder(@NonNull View itemView) {
            super(itemView);
            //timeTextView = itemView.findViewById(R.id.????);
        }
    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder transactionViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
