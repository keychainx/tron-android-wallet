package com.devband.tronwalletforandroid.ui.main.dto;

import com.devband.tronwalletforandroid.common.Constants;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Asset {

    private String name;

    private double balance;

    @Override
    public String toString() {
        return name + " (" + Constants.tronBalanceFormat.format(balance) + ")";
    }
}
