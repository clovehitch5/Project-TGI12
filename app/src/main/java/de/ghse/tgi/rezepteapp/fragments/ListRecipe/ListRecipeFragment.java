package de.ghse.tgi.rezepteapp.fragments.ListRecipe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import de.ghse.tgi.rezepteapp.MyViewPagerAdapter;
import de.ghse.tgi.rezepteapp.R;
import de.ghse.tgi.rezepteapp.StorageRecipe;


public class ListRecipeFragment extends Fragment {
    private ListRecipeControll ctrl;
    private FloatingActionButton fab;
    private StorageRecipe storage;
    private ListView list;
    private View view;
    private MyViewPagerAdapter pager;


    public ListRecipeFragment(MyViewPagerAdapter p){
        super();
        pager = p;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        storage = pager.getMainActivity().getStorage();
        view =inflater.inflate(R.layout.fragment_view_recipe, container, false);
        list = view.findViewById(R.id.listViewRecipe);
        ListRecipeListViewAdapte adapter = new ListRecipeListViewAdapte(pager.getMainActivity(),storage.getList());
        list.setAdapter(adapter);
        ctrl = new ListRecipeControll(this);
        fab =  view.findViewById(R.id.fabAdd);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pager.getMainActivity().setFrag(1);
            }
        });
        return view;
    }
}