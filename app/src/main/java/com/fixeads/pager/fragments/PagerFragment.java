package com.fixeads.pager.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fixeads.pager.R;
import com.fixeads.pager.model.Ad;

import java.util.ArrayList;

/**
 * Created by João Amaro Silva on 09-11-2015.
 */
public class PagerFragment extends Fragment{

    private View mView;
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    private DetailsPagerAdapter mDetailsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    private ArrayList<Ad> adsList = new ArrayList<Ad>();

    public static PagerFragment newInstance(ArrayList<Ad> ads) {

        Bundle args = new Bundle();
        if(ads!=null) {
            args.putSerializable("ads", ads);
        }
        PagerFragment fragment = new PagerFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public static PagerFragment newInstance() {

        PagerFragment fragment = new PagerFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_pager, container, false);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());

        mDetailsPagerAdapter = new DetailsPagerAdapter(getChildFragmentManager());

        mTabLayout = (TabLayout) mView.findViewById(R.id.tabs);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) mView.findViewById(R.id.viewPager);


        if(getArguments() != null && getArguments().getSerializable("ads") != null ) {
            adsList = (ArrayList<Ad>) getArguments().getSerializable("ads");
        }

        if(adsList.isEmpty()) {
            mViewPager.setAdapter(mSectionsPagerAdapter);
            mTabLayout.setupWithViewPager(mViewPager);
        }
        else{
            mTabLayout.setVisibility(View.GONE);
            mViewPager.setAdapter(mDetailsPagerAdapter);
        }

        return mView;
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch(position){
                case 0:
                    return AdListFragment.newInstance(0);
                case 1:
                    return MapsFragment.newInstance(0);
            }
            return com.fixeads.pager.fragments.AdListFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getString(R.string.list);
                case 1:
                    return getResources().getString(R.string.map);
            }
            return null;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class DetailsPagerAdapter extends FragmentPagerAdapter {

        public DetailsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            if(getArguments().getSerializable("ads") != null) {
                return DetailsFragment.newInstance(((ArrayList<Ad>)getArguments().getSerializable("ads")).get(position));
            }

            return null;
        }

        @Override
        public int getCount() {
            return adsList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return adsList.get(position).getTitle();
        }
    }

}
