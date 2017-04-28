package com.example.myapplication.service.entity;

import java.util.List;

/**
 * Created by win764-1 on 2016/12/12.
 */

public class Book {
    public int count;
    public int start;
    public int total;
    public List<BooksBean> books;

    public static class BooksBean {
        public RatingBean rating;
        public String subtitle;
        public String pubdate;
        public String origin_title;
        public String image;
        public String binding;
        public String catalog;
        public String pages;
        public ImagesBean images;
        public String alt;
        public String id;
        public String publisher;
        public String isbn10;
        public String isbn13;
        public String title;
        public String url;
        public String alt_title;
        public String author_intro;
        public String summary;
        public String price;
        public List<String> author;
        public List<TagsBean> tags;
        public List<String> translator;

        public static class RatingBean {
            public int max;
            public int numRaters;
            public String average;
            public int min;
        }

        public static class ImagesBean {
            public String small;
            public String large;
            public String medium;
        }

        public static class TagsBean {
            public int count;
            public String name;
            public String title;
        }
    }


}
