package com.cognizant.academy.restservice.model;

public interface AbstractStudent {

    Integer getId();
    void setId(Integer id);

    String getFirstName();
    void setFirstName(String firstName);

    String getLastName();
    void setLastName(String lastName);

    String getOccupation();
    void setOccupation(String occupation);

    String getAddress();
    void setAddress(String address);

    String getMajor();
    void setMajor(String major);

}
