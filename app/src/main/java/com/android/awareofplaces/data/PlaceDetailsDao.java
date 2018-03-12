package com.android.awareofplaces.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.Cursor;

/**
 * Created by user on 28-02-2018.
 */
@Dao
public interface PlaceDetailsDao {

    // count of all stored places
    @Query("SELECT COUNT(*) FROM "+PlaceDetails.TABLE_NAME)
    int count();

    @Insert
    long insert(PlaceDetails placeDetail);

    @Insert
    long[] insert(PlaceDetails[] placeDetails);

    @Query("SELECT * FROM "+PlaceDetails.TABLE_NAME)
    Cursor selectAll();

    @Query("SELECT * FROM "+PlaceDetails.TABLE_NAME+" WHERE "+PlaceDetails.COLUMN_ID+" =:id")
    Cursor selectById(long id);


    @Query("SELECT * FROM "+PlaceDetails.TABLE_NAME+" WHERE "+PlaceDetails.PLACE_ID+" =:place_id")
    Cursor selectByPlaceId(String place_id);

    @Query("DELETE FROM "+PlaceDetails.TABLE_NAME+" WHERE "+PlaceDetails.COLUMN_ID+" =:id")
    int deleteById(long id);

    @Update
    int update(PlaceDetails placeDetail);
}
