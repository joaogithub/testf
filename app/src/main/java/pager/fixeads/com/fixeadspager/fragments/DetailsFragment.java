package pager.fixeads.com.fixeadspager.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by João Amaro Silva on 08-11-2015.
 */
public class DetailsFragment  extends Fragment {

    public static DetailsFragment newInstance(int sectionNumber) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        //args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

}
