package com.android.awareofplaces.network;

import com.android.awareofplaces.network.TouristPlacesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by user on 27-02-2018.
 */

//https://maps.googleapis.com/maps/api/place/textsearch/json?query=tourist%20places%20in%20india&key=AIzaSyA8bOnO5cJzGBzPZg5B_uc1DSeg8Q2zz-Q
public interface PlacesSearchService {
    @GET("textsearch/json?")
    Call<TouristPlacesResponse> getTouristPlacesList(@Query("query") String query, @Query("key") String key);
}
