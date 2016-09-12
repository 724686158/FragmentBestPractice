package com.example.admin.fragmentbestpractice;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by admin on 2016/9/12.
 */
public class NewsContentFragment extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_content_frag, container, false);
        return view;
    }

    public void refresh(String newsTitle, String newsContent)
    {
        View visiblityLayout = view.findViewById(R.id.visibility_layout);
        visiblityLayout.setVisibility(view.VISIBLE);
        TextView newTitleText = (TextView)view.findViewById(R.id.news_title);
        TextView newsContentText = (TextView) view.findViewById(R.id.news_content);
        newTitleText.setText(newsTitle);
        newsContentText.setText(newsContent);

    }
}
