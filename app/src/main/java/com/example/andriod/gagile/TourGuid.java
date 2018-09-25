package com.example.andriod.gagile;


public class TourGuid {

    //==============================================//
    // this shows variables to be used in the list //
    //============================================//

    private int locationImg;
    private String locationName;
    private String locationAdd;

    //============================================//
    // this shows how information will be        //
    // displayed on the List Items              //
    //=========================================//

    public TourGuid(int locaImg, String locaName, String locaAdd){

        locationImg = locaImg;
        locationName = locaName;
        locationAdd = locaAdd;

    }

    //============================================//
    // this gets all the variable and return     //
    // them                                     //
    //=========================================//


    public int getLocationImg() {
        return locationImg;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getLocationAdd() {
        return locationAdd;
    }
}
