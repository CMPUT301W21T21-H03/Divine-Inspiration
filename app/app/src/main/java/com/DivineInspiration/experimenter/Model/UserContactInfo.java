package com.DivineInspiration.experimenter.Model;

public class UserContactInfo {
    private String cityName;
    private String email;

    /**
     * Contact person info constructor
     * @param cityName city of person
     * @param email email of person
     */
    public UserContactInfo(String cityName, String email) {
        this.cityName = cityName;
        this.email = email;
    }

    /**
     * Default empty constructor for a person's contact
     */
    public UserContactInfo() {
        this.cityName = "";
        this.email = "";
    }

    /**
     * Gets the user email
     * @return email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the user email
     * @param email new email of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets city name of the user
     * @return city name if the user
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Sets a new city name for the user
     * @param cityName new city name for the user
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}