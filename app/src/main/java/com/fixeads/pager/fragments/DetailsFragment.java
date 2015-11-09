package com.fixeads.pager.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fixeads.pager.R;
import com.fixeads.pager.model.Ad;

/**
 * Created by João Amaro Silva on 08-11-2015.
 */
public class DetailsFragment  extends Fragment {

    private View mView;
    private TextView title, description, price, created;
    private ViewPager detailsPager;

    private Ad mAd;

    public static DetailsFragment newInstance(Ad ad) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable("ad", ad);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_details, container, false);

        title = (TextView) mView.findViewById(R.id.adTitleTextView);
        description = (TextView) mView.findViewById(R.id.adDescriptionTextView);
        price = (TextView) mView.findViewById(R.id.adPriceTextView);
        created = (TextView) mView.findViewById(R.id.txtAdCreated);

        if(getArguments() != null) {
            mAd = (Ad) getArguments().getSerializable("ad");

            if(mAd.getDescription() != null)
                description.setText(mAd.getDescription());

            if(mAd.getTitle() != null)
                title.setText(mAd.getTitle());

            if(mAd.getCreated() != null)
                created.setText(mAd.getCreated());

            if(mAd.getList_label() != null)
                price.setText(mAd.getList_label());
        }

        return mView;
    }
}
