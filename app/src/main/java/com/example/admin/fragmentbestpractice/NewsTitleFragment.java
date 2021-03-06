package com.example.admin.fragmentbestpractice;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/9/12.
 */
public class NewsTitleFragment extends Fragment implements AdapterView.OnItemClickListener {


    private ListView newsTitleListView;
    private List<News> newsList;
    private NewsAdapter adapter;
    private boolean isTwoPane;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        newsList = getNews();
        adapter = new NewsAdapter(activity, R.layout.news_item, newsList);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_frag, container, false);
        newsTitleListView = (ListView) view.findViewById(R.id.news_title_list_view);
        newsTitleListView.setAdapter(adapter);
        newsTitleListView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.news_content_layout) != null)
        {
            isTwoPane = true;

        }
        else
        {
            isTwoPane = false;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        News news = newsList.get(position);
        if (isTwoPane)
        {
            NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_content_fragment);
            newsContentFragment.refresh(news.getTitle(), news.getContent());
        }
        else
        {
            NewsContentActivity.actionStart(getActivity(), news.getTitle(), news.getContent());
        }
    }

    public List<News> getNews() {

        List<News> newsList = new ArrayList<News>();
        News news1 = new News();
        news1.setTitle("Title1 XXXXXXXXXXXXXXXXXXXXXXXXXXX");
        news1.setContent("Content!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        newsList.add(news1);
        News news2 = new News();
        news2.setTitle("Title2 XXXXXXXXXXXXXXXXXXXXXXXXXXX");
        news2.setContent("Content2!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        newsList.add(news2);
        return newsList;
    }



}
