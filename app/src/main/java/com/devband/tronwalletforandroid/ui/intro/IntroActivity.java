package com.devband.tronwalletforandroid.ui.intro;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.devband.tronwalletforandroid.R;
import com.devband.tronwalletforandroid.common.CommonActivity;
import com.devband.tronwalletforandroid.ui.backupaccount.BackupAccountActivity;
import com.devband.tronwalletforandroid.ui.createwallet.CreateWalletActivity;
import com.devband.tronwalletforandroid.ui.login.LoginActivity;

public class IntroActivity extends CommonActivity implements IntroView {

    private boolean mIsBackClick = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        mPresenter = new IntroPresenter(this);
        mPresenter.onCreate();
    }

    @Override
    public void startCreateAccountActivity() {
        if (!mIsBackClick) {
            startActivity(CreateWalletActivity.class);
        }
        finishActivity();
    }

    @Override
    public void startLoginActivity() {
        if (!mIsBackClick) {
            startActivity(LoginActivity.class);
        }
        finishActivity();
    }

    @Override
    public void startBackupAccountActivity() {
        if (!mIsBackClick) {
            startActivity(BackupAccountActivity.class);
        }
        finishActivity();
    }

    @Override
    public void onBackPressed() {
        mIsBackClick = true;

        super.onBackPressed();
    }
}
