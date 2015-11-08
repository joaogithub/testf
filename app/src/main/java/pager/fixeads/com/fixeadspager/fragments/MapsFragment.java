package pager.fixeads.com.fixeadspager.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by João Amaro Silva on 08-11-2015.
 */
public class MapsFragment  extends Fragment {

    public static MapsFragment newInstance(int sectionNumber) {
        MapsFragment fragment = new MapsFragment();
        Bundle args = new Bundle();
        //args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

}
