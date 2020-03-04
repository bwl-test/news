package com.example.newsdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ContentFragment extends Fragment {
    private TextView mTitleView;
    private TextView mContentView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_fragment, container, false);
        mTitleView = (TextView)view.findViewById(R.id.content_view_title);
        mContentView = (TextView)view.findViewById(R.id.content_view_content);
        return view;
    }

    public void updateNews(News news) {
        mTitleView.setText(news.getTitle());
        mContentView.setText(news.getContent());
    }
}
