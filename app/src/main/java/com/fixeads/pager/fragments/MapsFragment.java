package com.fixeads.pager.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fixeads.pager.R;
import com.fixeads.pager.model.Ad;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

/**
 * Created by João Amaro Silva on 08-11-2015.
 */
public class MapsFragment extends Fragment implements OnMapReadyCallback, GoogleMap.InfoWindowAdapter {

    private static final String TAG = "MapsFragment";
    protected View mView;
    private SupportMapFragment mMapFragment;
    public static GoogleMap mGoogleMap;
    private ArrayList<Ad> mList = new ArrayList<Ad>();

    public static MapsFragment newInstance(ArrayList<Ad> ads) {
        MapsFragment fragment = new MapsFragment();
        Bundle args = new Bundle();
        args.putSerializable("ads", ads);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_map, container, false);

        mMapFragment = SupportMapFragment.newInstance();
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.containerRL, mMapFragment);
        fragmentTransaction.commit();

        mMapFragment.getMapAsync(this);

        return mView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mGoogleMap = googleMap;

        // Add a marker
        if(getArguments().getSerializable("ads") != null){
            mList = (ArrayList<Ad>) getArguments().getSerializable("ads");

            for(Ad ad:mList){
                LatLng adLatLong = new LatLng(ad.getMap_lat(), ad.getMap_lon());
                googleMap.addMarker(new MarkerOptions().position(adLatLong).title(ad.getTitle()).snippet(ad.getList_label()));
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(adLatLong));
                googleMap.setInfoWindowAdapter(this);
            }
        }

        googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Log.e(TAG, "Clicked " + marker.getTitle());
            }
        });

    }

    public static void updateMarkers(ArrayList<Ad> list){
        for(Ad ad:list){
            LatLng adLatLong = new LatLng(ad.getMap_lat(), ad.getMap_lon());
            if(mGoogleMap != null) {
                mGoogleMap.addMarker(new MarkerOptions().position(adLatLong).title(ad.getTitle()).snippet(ad.getList_label()));
                mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(adLatLong));
                Log.i(TAG, ad.getTitle() + " " +adLatLong);
            }
        }
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }
}
