package com.DivineInspiration.experimenter.Activity.UI.TrialTests;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.DivineInspiration.experimenter.Controller.TrialManager;
import com.DivineInspiration.experimenter.Model.Trial.BinomialTrial;
import com.DivineInspiration.experimenter.Model.Trial.CountTrial;
import com.DivineInspiration.experimenter.Model.Trial.Trial;
import com.DivineInspiration.experimenter.R;
import com.google.android.material.snackbar.Snackbar;

public class CountTest extends Fragment {
    private CountTrial current;

    // text views
    TextView countTextBox;
    CheckBox requireGeo;
    TextView submit;

    private boolean requireGeoCheck;

    /**
     * Constructor
     */
    public CountTest() {
        super(R.layout.trial_count);
//        CountTrial trial = new CountTrial(trialUserID, trialExperimentID);
//        current = trial;
    }

    /**
     * Shows alert message on the bottom of the parent fragment page
     * @param error   is the alert an error
     * @param message message
     */
    private void showAlert(boolean error, String message) {
        Snackbar snackbar = Snackbar.make(getParentFragment().getView(), message, Snackbar.LENGTH_LONG);
        snackbar.getView().setBackgroundColor(Color.parseColor(error ? "#913c3c" : "#2e6b30"));
        snackbar.show();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle extra = getArguments();
        current = (CountTrial) extra.getSerializable("trial");

        countTextBox = view.findViewById(R.id.editTextNumber);
        requireGeo = view.findViewById(R.id.require_geo_location2);
        submit = view.findViewById(R.id.count_submit);

        requireGeo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                // set geo check to the state of checkbox
                requireGeoCheck = b;
                // do something? or store in Trial?
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String countText = countTextBox.getText().toString();
                if (countText.length() == 0) {
                    // counts as cancel for now
                    // show error
                    showAlert(true,"Trial not recorded");
                } else {
                    current.setCount(Integer.parseInt(countText));
                    // record to experiment manager
                    TrialManager.getInstance().addTrial(current);
                }
                // return
                Navigation.findNavController(view).popBackStack();
            }
        });

    }

    public Trial getTrial() {
        return current;
    }
}
