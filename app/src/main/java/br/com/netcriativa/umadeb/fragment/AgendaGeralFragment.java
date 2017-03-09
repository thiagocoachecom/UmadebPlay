package br.com.netcriativa.umadeb.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.netcriativa.umadeb.R;
import br.com.netcriativa.umadeb.adapter.MoviesAdapter;
import br.com.netcriativa.umadeb.helper.DividerItemDecoration;
import br.com.netcriativa.umadeb.model.Movie;
import br.com.netcriativa.umadeb.model.User;


/**
 * A simple {@link Fragment} subclass.
 */
public class AgendaGeralFragment extends Fragment {

}
