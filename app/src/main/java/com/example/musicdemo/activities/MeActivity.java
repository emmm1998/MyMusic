package com.example.musicdemo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.musicdemo.R;
import com.example.musicdemo.utils.UserUtils;

public class MeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        initView();
    }
    private void initView(){
        initNavBar(true,"个人中心",false);
    }
    public void onChangeClick(View v){
startActivity(new Intent(this,ChangePasswordActivity.class));
    }
    public void onLogoutClick(View v){
        UserUtils.logout(this);
    }
}
