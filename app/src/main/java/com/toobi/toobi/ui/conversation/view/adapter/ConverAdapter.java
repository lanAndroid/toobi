package com.toobi.toobi.ui.conversation.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Rampant on 2017/11/6.
 */

public class ConverAdapter extends FragmentPagerAdapter {
    private List<String> list;
    private List<Fragment> flist;

    public ConverAdapter(FragmentManager fm, List<String> list, List<Fragment> flist) {
        super(fm);
        this.list = list;
        this.flist = flist;
    }

    @Override
    public Fragment getItem(int position) {
        return flist.get(position);
    }

    @Override
    public int getCount() {
        return flist.size();
    }



    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
