package com.fixeads.pager.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fixeads.pager.R;
import com.fixeads.pager.activity.MainActivity;
import com.fixeads.pager.adapter.AdapterAds;
import com.fixeads.pager.model.Ad;
import com.fixeads.pager.model.AdResponse;
import com.fixeads.pager.network.RequestAdapter;
import com.fixeads.pager.network.listener.RequestObjectListener;
import com.fixeads.pager.network.model.ErrorCode;

import java.util.ArrayList;

/**
 * Created by João Amaro Silva on 08-11-2015.
 */
public class AdListFragment extends Fragment {

    private static final String TAG = "AdListFragment";
    protected FragmentActivity mActivity;
    protected View mView;
    protected RecyclerView mRecyclerView;
    private ArrayList<Ad> mList;
    private int page = 1;
    private boolean loading = true;
    private int pastVisiblesItems, visibleItemCount, totalItemCount;
    private LinearLayoutManager mLayoutManager;

    public static AdListFragment newInstance(int sectionNumber) {
        AdListFragment fragment = new AdListFragment();
        Bundle args = new Bundle();
        //args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    protected void showError(String message) {
        if (mView == null) return;

        mRecyclerView.setVisibility(View.GONE);
        mView.findViewById(R.id.prgBar).setVisibility(View.GONE);

        TextView textView = (TextView) mView.findViewById(R.id.txtErrorMessage);
        textView.setVisibility(View.VISIBLE);
        textView.setText(message);

        //try to load list again
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestList(1);
            }
        });
    }

    public void requestList(final int page) {

        mView.findViewById(R.id.prgBar).setVisibility(View.VISIBLE);

        RequestAdapter.getAllAds(getContext(), new RequestObjectListener<AdResponse>() {
            @Override
            public void onSuccess(AdResponse response) {
                mRecyclerView.setVisibility(View.VISIBLE);
                mView.findViewById(R.id.txtErrorMessage).setVisibility(View.GONE);
                mView.findViewById(R.id.rltErrorRefresh).setVisibility(View.GONE);

                if(response.getAds()!=null)
                    mList.addAll(response.getAds());

                AdapterAds adapterAds = new AdapterAds((MainActivity) mActivity, mList);

                mRecyclerView.setAdapter(adapterAds);

                mView.findViewById(R.id.prgBar).setVisibility(View.GONE);

            }

            @Override
            public void onError(ErrorCode errorCode, String message) {

                if (errorCode == null) {
                    return;
                } else {
                    showError(message);
                }

                mView.findViewById(R.id.prgBar).setVisibility(View.GONE);

            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        mActivity = getActivity();

        mList = new ArrayList<Ad>();

        mRecyclerView = (RecyclerView) mView.findViewById(R.id.rcvENSupport);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(mActivity);
        mRecyclerView.setLayoutManager(mLayoutManager);

        requestList(1);

        return mView;
    }
}
