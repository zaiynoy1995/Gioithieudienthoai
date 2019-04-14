package com.zaj.gioithieudienthoai;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<PhoneFragment> phoneFragments = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();

    public void addFragment(PhoneFragment fragment,String title){
        phoneFragments.add(fragment);
        titleList.add(title);
    }

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return phoneFragments.get(i);
    }

    @Override
    public int getCount() {
        return phoneFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
