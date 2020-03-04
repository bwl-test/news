package com.example.newsdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TitleFragment extends Fragment {
    private boolean mTwoPanel = false;
    private List<News> mNews = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.title_fragment, container, false);
        RecyclerView listView = (RecyclerView)view.findViewById(R.id.title_view_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listView.setLayoutManager(layoutManager);
        initNews();
        NewsAdapter adapter = new NewsAdapter(mNews);
        listView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.content_fragment) != null) {
            mTwoPanel = true;
        }
    }

    private void initNews() {
        for (int i=0; i<100; ++i) {
            mNews.add(new News("Tile "+i, "This is Content for news "+i));
        }
    }

    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
        private List<News> mNews;

        NewsAdapter(List<News> news) {
            mNews = news;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.title_item_view, parent, false);
            final ViewHolder holder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getAdapterPosition();
                    News news = mNews.get(pos);
                    if (mTwoPanel) {
                        ContentFragment contentFragment = (ContentFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.content_fragment);
                        contentFragment.updateNews(news);
                    } else {
                        ContentActivity.actionStart(getActivity(), news);
                    }

                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            News news = mNews.get(position);
            holder.mTextView.setText(news.getTitle());
        }

        @Override
        public int getItemCount() {
            return mNews.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            private TextView mTextView;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                mTextView = (TextView) itemView.findViewById(R.id.title_item_view_title);
            }
        }
    }

}
