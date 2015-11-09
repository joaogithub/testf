package com.fixeads.pager.adapter;

/**
 * Created by João Amaro Silva on 08-11-2015.
 */

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fixeads.pager.R;
import com.fixeads.pager.activity.MainActivity;
import com.fixeads.pager.fragments.DetailsFragment;
import com.fixeads.pager.model.Ad;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by João Amaro Silva on 09/11/2015.
 */
public class AdapterAds extends RecyclerView.Adapter<AdapterAds.ViewHolder> {

    private static final String TAG = "AdapterAds";
    private MainActivity mActivity;
    private List<Ad> adList;

    public AdapterAds(MainActivity mActivity, List<Ad> list) {
        this.mActivity = mActivity;
        this.adList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mActivity)
                .inflate(R.layout.adapter_ads, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        final Ad ad = adList.get(position);

        viewHolder.title.setText(ad.getTitle());

        viewHolder.price.setText(ad.getList_label());

        viewHolder.created.setText(ad.getCreated());

        if(ad.getUrl() != null ){
            Picasso.with(mActivity)
                    .load(ad.getUrl())
                    .error(R.color.light_grey)
                    .into(viewHolder.cover);
        }

        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w(TAG, "ADS: " + ad.getTitle());
                mActivity.performTransactionDetails("Ad", DetailsFragment.newInstance(ad), "DetailsFragment");
            }
        });
    }

    @Override
    public int getItemCount() {
        return adList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView cover;
        public TextView title, price, created;
        public View view;

        public ViewHolder(View itemView) {
            super(itemView);

            view = itemView;

            cover = (ImageView) itemView.findViewById(R.id.imvAdCover);
            title = (TextView) itemView.findViewById(R.id.txtAdTitle);
            created = (TextView) itemView.findViewById(R.id.txtAdCreated);
            price = (TextView) itemView.findViewById(R.id.txtAdPrice);
        }

    }
}

