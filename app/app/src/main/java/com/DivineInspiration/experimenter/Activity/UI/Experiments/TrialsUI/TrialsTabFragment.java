package com.DivineInspiration.experimenter.Activity.UI.Experiments.TrialsUI;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.DivineInspiration.experimenter.Activity.Observer;
import com.DivineInspiration.experimenter.Controller.ExperimentManager;
import com.DivineInspiration.experimenter.Controller.TrialManager;
import com.DivineInspiration.experimenter.Model.Trial.Trial;
import com.DivineInspiration.experimenter.R;

import java.util.ArrayList;
import java.util.List;

/**
 * This class deals with the UI for displaying the trials for a given experiment. (One of the tab of Experiment fragment)
 * It is one of the tabs of Experiment fragment.
 * @see: trial_list
 */
public class TrialsTabFragment extends Fragment implements Observer {

    private TrialListAdapter adapter;
    private List<Trial> trialArrayList = new ArrayList<>();

    private TrialManager.OnTrialListReadyListener callback;
    public  TrialsTabFragment(TrialManager.OnTrialListReadyListener callback){
        this.callback = callback;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.trialArrayList = new ArrayList<>();
        this.adapter = new TrialListAdapter();

    }

    /**
     * Runs when the view is created. Similar to the activity's onCreate
     * @param: inflater:LayoutInflater, container:ViewGroup, savedInstanceState:Bundle
     * @return: :View
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.trial_list, container, false);

        adapter = new TrialListAdapter(trialArrayList, callback);
        RecyclerView recycler = view.findViewById(R.id.trialList);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(adapter);
        recycler.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        return view;
    }

    /**
     * Implementation of the observer interface. This method updates its data
     * when update method is called form ExperimentFragment (which is the observable).
     */
    @Override
    public void update(Object data) {
      Log.d("woah trial tab", "" +   ((List<Trial>) data).size());
            trialArrayList.clear();
            trialArrayList.addAll((List<Trial>) data);
        Log.d("woah trial tab", "" +   ((List<Trial>) data).size());

        if (adapter != null){
            adapter.notifyDataSetChanged();
        }

    }
}