package com.example.myapplication.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.example.myapplication.R;

public class MainActivity2 extends AppCompatActivity {

    private RadioGroup mRadioGroup;
    private AFragment aFragment;
    private BFragment bFragment;
    private CFragment cFragment;
    private DFragment dFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initEvent();
    }

    private void initView() {
        mRadioGroup = (RadioGroup) findViewById(R.id.rg_bottom);
    }

    private void initEvent() {
        showFragment(0);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_message:
                        showFragment(0);
                        break;
                    case R.id.rb_contact:
                        showFragment(1);
                        break;
                    case R.id.rb_dynamic:
                        showFragment(2);
                        break;
                    case R.id.rb_mine:
                        showFragment(3);
                        break;
                }
            }
        });
    }


    public void showFragment(int index) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        hideAllFragment(ft);
        switch (index) {
            case 0:
                if (aFragment != null) {
                    ft.show(aFragment);
                } else {
                    aFragment = new AFragment();
                    ft.add(R.id.fl, aFragment);
                }
                break;
            case 1:
                if (bFragment != null) {
                    ft.show(bFragment);
                } else {
                    bFragment = new BFragment();
                    ft.add(R.id.fl, bFragment);
                }
                break;
            case 2:
                if (cFragment != null) {
                    ft.show(cFragment);
                } else {
                    cFragment = new CFragment();
                    ft.add(R.id.fl, cFragment);
                }
                break;
            case 3:
                if (dFragment != null) {
                    ft.show(dFragment);
                } else {
                    dFragment = new DFragment();
                    ft.add(R.id.fl, dFragment);
                }
                break;
        }
        ft.commit();
    }

    private void hideAllFragment(FragmentTransaction ft) {
        if (aFragment != null) {
            ft.hide(aFragment);
        }
        if (bFragment != null) {
            ft.hide(bFragment);
        }
        if (cFragment != null) {
            ft.hide(cFragment);
        }
        if (dFragment != null) {
            ft.hide(dFragment);
        }
    }
}
