package com.example.myapplication.service.view;


import com.example.myapplication.service.entity.Book;

/**
 * Created by win764-1 on 2016/12/12.
 */

public interface BookView extends View {
    void onSuccess(Book mBook);
    void onError(String result);
}
