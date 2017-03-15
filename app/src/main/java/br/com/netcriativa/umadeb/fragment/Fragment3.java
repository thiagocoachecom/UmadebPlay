package br.com.netcriativa.umadeb.fragment;

/**
 * Created by Administrator on 10/03/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.netcriativa.umadeb.R;


public class Fragment3 extends Fragment{
    private static final String KEY_TITLE = "title";

    public Fragment3() {
        // Required empty public constructor
    }

    public static Fragment newInstance(String demo) {
        Fragment3 f = new Fragment3();
        Bundle args = new Bundle();
        args.putString(KEY_TITLE, demo);
        f.setArguments(args);
        return (f);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_3, container, false);
    }

}
