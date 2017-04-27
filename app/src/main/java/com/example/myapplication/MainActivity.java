package com.example.myapplication;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    private RadioGroup mRadioGroup;
    private TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initView() {
        mRadioGroup = (RadioGroup) findViewById(R.id.rg_bottom);
        mTabHost = getTabHost();
    }

    private void initEvent() {
        initTabhost();
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_message:
                        mTabHost.setCurrentTab(0);
                        break;
                    case R.id.rb_contact:
                        mTabHost.setCurrentTab(1);
                        break;
                    case R.id.rb_dynamic:
                        mTabHost.setCurrentTab(2);
                        break;
                }
            }
        });
    }

    private void initTabhost() {
        mTabHost.setFocusable(true);
        mTabHost.setClickable(true);
        //If you are using {@link TabSpec#setContent(android.content.Intent)}, this must be called since the activityGroup is needed to launch the local activity.
        mTabHost.setup(this.getLocalActivityManager());
        //message
        mTabHost.addTab(mTabHost.newTabSpec("1")
            .setIndicator("message")
            .setContent(new Intent(this, MessageActivity.class)));

        //contact
        mTabHost.addTab(mTabHost.newTabSpec("2")
            .setIndicator("contact")
            .setContent(new Intent(this, ContactActivity.class)));

        //dynamic
        mTabHost.addTab(mTabHost.newTabSpec("3")
            .setIndicator("dynamic")
            .setContent(new Intent(this, DynamicActivity.class)));

        //default show message
        mTabHost.setCurrentTab(0);

    }
}
