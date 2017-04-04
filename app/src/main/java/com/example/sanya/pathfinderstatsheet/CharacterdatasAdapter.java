package com.example.sanya.pathfinderstatsheet;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by sanya on 2017.04.04..
 */

public class CharacterdatasAdapter extends FragmentPagerAdapter {
    Context mContext;

    public CharacterdatasAdapter(Context context, FragmentManager fm)  {
        super(fm);
        mContext = context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)   {
            case 0:
                return new Basicdatas();
            case 1:
                return new Attributes();
            case 2:
                return new Skills();
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)   {
            case 0:
                return mContext.getString(R.string.basicdatas);
            case 1:
                return mContext.getString(R.string.attributes);
            case 2:
                return mContext.getString(R.string.skills);
            default:
                return null;
        }
    }

}
