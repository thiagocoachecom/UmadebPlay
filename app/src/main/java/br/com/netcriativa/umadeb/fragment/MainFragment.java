package br.com.netcriativa.umadeb.fragment;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import br.com.netcriativa.umadeb.R;
import br.com.netcriativa.umadeb.activity.MainActivity;
import br.com.netcriativa.umadeb.adapter.MainAdapter;
import br.com.netcriativa.umadeb.model.FeedItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private static final String KEY_TITLE = "title";

    public MainFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(String demo) {
        MainFragment f = new MainFragment();

        Bundle args = new Bundle();

        args.putString(KEY_TITLE, demo);
        f.setArguments(args);

        return (f);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(getFragmentManager(),
                FragmentPagerItems.with(getContext())
                        .add("Congresso 2018", Fragment1.class)
                        .add("Loja Umadeb", Fragment2.class)
                        .add("hospedagem", Fragment3.class)
                        .create());

        ViewPager viewPager = (ViewPager) v.findViewById(R.id.astab_home_app);
        viewPager.setAdapter(adapter);

        SmartTabLayout viewPagerTab = (SmartTabLayout) v.findViewById(R.id.view_pager_tab);
        viewPagerTab.setViewPager(viewPager);

        return v;
    }

}
