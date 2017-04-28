package com.example.myapplication.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.myapplication.R;
import com.example.myapplication.service.entity.Book;
import com.example.myapplication.service.presenter.BookPresenter;
import com.example.myapplication.service.view.BookView;
import com.example.myapplication.ui.adapter.MyAdapter;
import com.example.myapplication.utils.ToastUtil;


public class MessageActivity extends AppCompatActivity {
    private EditText text;
    private Button button;
    private ListView lv;
    private BookPresenter mBookPresenter = new BookPresenter(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        text = (EditText) findViewById(R.id.et_key);
        button = (Button) findViewById(R.id.button);
        lv = (ListView) findViewById(R.id.lv);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String trim = text.getText().toString().trim();
                mBookPresenter.getSearchBooks(trim, null, 0, 1);
            }
        });
        mBookPresenter.onCreate();
        mBookPresenter.attachView(mBookView);
    }

    private BookView mBookView = new BookView() {
        @Override
        public void onSuccess(Book mBook) {
            lv.setAdapter(new MyAdapter(mBook));
        }

        @Override
        public void onError(String result) {
            ToastUtil.show(result);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBookPresenter.onStop();
        ToastUtil.show("MessageActivity onDestroy");
    }
}