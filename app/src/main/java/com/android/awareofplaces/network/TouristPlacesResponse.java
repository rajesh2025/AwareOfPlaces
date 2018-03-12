package com.android.awareofplaces.network;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by user on 27-02-2018.
 */

public class TouristPlacesResponse {
    @SerializedName("next_page_token")
    private  String next_page_token;
    @SerializedName("results")
   private List<TouristPlaces> results;
    @SerializedName("status")
    private  String status;

    public String getNext_page_token() {
        return next_page_token;
    }

    public void setNext_page_token(String next_page_token) {
        this.next_page_token = next_page_token;
    }

    public List<TouristPlaces> getResults() {
        return results;
    }

    public void setResults(List<TouristPlaces> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
