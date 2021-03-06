package com.devband.tronwalletforandroid.common;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

import com.devband.tronwalletforandroid.R;
import com.devband.tronwalletforandroid.ui.accountdetail.AccountDetailActivity;
import com.devband.tronwalletforandroid.ui.blockdetail.BlockDetailActivity;

import org.tron.protos.Protocol;

public class Utils {

    public static String getContractTypeString(Context context, int contractType) {

        String[] contractTypes = context.getResources().getStringArray(R.array.contract_types);

        try {
            if (contractType == Protocol.Transaction.Contract.ContractType.UNRECOGNIZED.getNumber()) {
                return context.getString(R.string.unrecognized_text);
            }
            return contractTypes[contractType];
        } catch (Exception e) {
            return context.getString(R.string.unrecognized_text);
        }
    }

    public static String getCommaNumber(int number) {
        return Constants.numberFormat.format(number);
    }

    public static String getCommaNumber(long number) {
        return Constants.numberFormat.format(number);
    }

    public static void setBlockDetailAction(Context context, TextView textView, long blockNum) {
        SpannableString content = new SpannableString(Constants.numberFormat.format(blockNum));
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);

        textView.setText(content);
        textView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), BlockDetailActivity.class);
            intent.putExtra(BlockDetailActivity.EXTRA_BLOCK_NUMBER, blockNum);
            context.startActivity(intent);
        });
    }
}