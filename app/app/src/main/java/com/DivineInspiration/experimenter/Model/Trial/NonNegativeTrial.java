package com.DivineInspiration.experimenter.Model.Trial;

import com.DivineInspiration.experimenter.Model.User;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.firestore.GeoPoint;


import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class NonNegativeTrial extends Trial {
    private int count;

    /**
     * The constructor
     * @param trialID
     * ID of trial
     * @param trialUserID
     * ID of user
     * @param trialOwnerName
     * name of the experimenter that did the trial
     * @param trialExperimentID
     * ID of the experiment
     * @param trialDate
     * date of when the trial occurred
     * @param count
     * number of count
     * @param location
     * location of where the trial occurred
     */
    public NonNegativeTrial(String trialID, String trialUserID,String trialOwnerName ,String trialExperimentID, LocalDate trialDate, int count, LatLng location){
        super(trialID, trialUserID, trialOwnerName ,trialExperimentID, trialDate,location);
        this.trialType = Trial.NONNEGATIVE;
        this.count = count;
    }

    /**
     * The constructor
     * @param trialUserID
     * ID of user
     * @param trialOwnerName
     * name of the experimenter that did the trial
     * @param trialExperimentID
     * ID of the experiment
     */
    public NonNegativeTrial(String trialUserID, String trialOwnerName, String trialExperimentID) {
        super(trialUserID, trialOwnerName,trialExperimentID);
        this.trialType = Trial.NONNEGATIVE;
        this.count = 0;
    }


    /**
     * The constructor
     * @param trialUserID
     * ID of user
     * @param trialOwnerName
     * name of the experimenter that did the trial
     * @param trialExperimentID
     * ID of the experiment
     * @param count
     * number of count
     * @param location
     * location of where the trial occurred
     */
    public NonNegativeTrial(String trialUserID,String trialOwnerName ,String trialExperimentID, int count, LatLng location) {
        super(trialUserID, trialOwnerName,trialExperimentID);
        this.trialType = Trial.NONNEGATIVE;
        this.count = count;
        this.location = location;
    }


    /**
     * The constructor
     * @param trialID
     * ID of trial
     * @param trialUserID
     * ID of user
     * @param trialOwnerName
     * name of the experimenter that did the trial
     * @param trialExperimentID
     * ID of the experiment
     * @param trialDate
     * date of when the trial occurred
     * @param count
     * number of count
     */
    public NonNegativeTrial(String trialID, String trialUserID,String trialOwnerName ,String trialExperimentID, LocalDate trialDate, int count) {
        super(trialID, trialUserID,trialOwnerName ,trialExperimentID, trialDate);
        this.trialType = Trial.NONNEGATIVE;
        this.count = count;
    }

    /**
     * Mock object constructor for testing purposes
     */
    public NonNegativeTrial() {
        super("test", "test", "test","test", LocalDate.now().plusDays(new Random().nextInt(40) - 20));
        this.trialType = Trial.NONNEGATIVE;
        Random rng = new Random();
        count = rng.nextInt(20);
    }

    /**
     * Increments count by one
     */
    public void addCount() {
        ++count;
    }

    /**
     * Sets count
     * @param count new count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Gets current count
     * @return count of the trial
     */
    public int getCount() {
        return count;
    }
}