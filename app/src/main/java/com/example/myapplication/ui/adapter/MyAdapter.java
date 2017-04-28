package com.example.myapplication.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.service.entity.Book;

public class MyAdapter extends BaseAdapter {

    private Book mBook;

    public MyAdapter(Book mBook) {
        this.mBook = mBook;
    }

    @Override
    public int getCount() {
        return mBook.books.size();
    }

    @Override
    public Book.BooksBean getItem(int position) {
        return mBook.books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Glide.with(parent.getContext()).load(getItem(position).image).into(viewHolder.mImg);
        viewHolder.mTitle.setText(getItem(position).title);
        viewHolder.mAuthor.setText(getItem(position).author_intro);
        return convertView;
    }
    class ViewHolder{

        private final ImageView mImg;
        private final TextView mTitle;
        private final TextView mAuthor;

        public ViewHolder(View view) {
            mImg = (ImageView) view.findViewById(R.id.iv_img);
            mTitle = (TextView) view.findViewById(R.id.title);
            mAuthor = (TextView) view.findViewById(R.id.author);
        }
    }


}