package br.com.netcriativa.umadeb.fragment;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

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
import br.com.netcriativa.umadeb.adapter.MainAdapter;
import br.com.netcriativa.umadeb.model.FeedItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment{
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

        return v;
    }

}
