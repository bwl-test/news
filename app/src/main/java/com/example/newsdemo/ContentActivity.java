package com.example.newsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class ContentActivity extends AppCompatActivity {
    public static void actionStart(Context context, News news) {
        Intent intent = new Intent(context, ContentActivity.class);
        intent.putExtra("news", news);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_panel);

        News news = (News)getIntent().getParcelableExtra("news");
        ContentFragment contentFragment = (ContentFragment)getSupportFragmentManager().findFragmentById(R.id.content_fragment);
        contentFragment.updateNews(news);
    }
}
