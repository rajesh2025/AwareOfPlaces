package com.android.awareofplaces.network;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by user on 27-02-2018.
 */

public class TouristPlaces {

    @SerializedName("id")
    private String id;
    @SerializedName("formatted_address")
    private String formatted_address;
    @SerializedName("name")
    private String name;
    @SerializedName("icon")
    private String icon;
    @SerializedName("place_id")
    private String place_id;
    @SerializedName("photos")
    private List<PlacePhotos> placePhotos;

    @SerializedName("rating")
    private  float rating;

    public List<PlacePhotos> getPlacePhotos() {
        return placePhotos;
    }

    public void setPlacePhotos(List<PlacePhotos> placePhotos) {
        this.placePhotos = placePhotos;
    }

    public String getFormatted_address() {
        return formatted_address;
    }

    public void setFormatted_address(String formatted_address) {
        this.formatted_address = formatted_address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private class PlacePhotos {

        @SerializedName("height")
        private String height;
        @SerializedName("width")
        private String width;
        @SerializedName("photo_reference")
        private String photo_reference;

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }

        public String getPhoto_reference() {
            return photo_reference;
        }

        public void setPhoto_reference(String photo_reference) {
            this.photo_reference = photo_reference;
        }
    }
}
