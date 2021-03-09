package com.DivineInspiration.experimenter;

public class ContactPersonInfo {
    private String address;
    private int phoneNumber;
    private String cityName;

    /**
     * Contact person info constructor
     * @param address
     * Physical address of person
     * @param phoneNumber
     * Phone number of person
     * @param cityName
     * City of person
     */
    public ContactPersonInfo(String address, int phoneNumber, String cityName) {
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.cityName = cityName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
