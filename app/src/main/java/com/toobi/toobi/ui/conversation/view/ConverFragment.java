package com.toobi.toobi.ui.conversation.view;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import com.toobi.toobi.R;
import com.toobi.toobi.base.BaseFragment;
import com.toobi.toobi.ui.conversation.view.adapter.ConverAdapter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rampant on 2017/11/5.
 */

public class ConverFragment extends BaseFragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<String> list = new ArrayList<>();
    private List<Fragment> flist = new ArrayList<>();


    @Override
    protected void initPrepare() {

    }

    @Override
    protected void onInvisible() {

    }

    @Override
    protected void initData() {
        list.add("消息");
        list.add("好友");

        flist.add(new FansFragment());
        flist.add(new FriendFragment());
        FragmentManager manager = getFragmentManager();
        ConverAdapter converAdapter = new ConverAdapter(manager, list, flist);
        viewPager.setAdapter(converAdapter);
        converAdapter.notifyDataSetChanged();
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    protected View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_conver, null);
        tabLayout = view.findViewById(R.id.conver_tab);
        viewPager = view.findViewById(R.id.conver_viewpager);
        return view;
    }
}