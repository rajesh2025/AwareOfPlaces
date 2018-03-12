package com.android.awareofplaces.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.provider.BaseColumns;

/**
 * Created by user on 28-02-2018.
 */
@Entity(tableName = PlaceDetails.TABLE_NAME)
public class PlaceDetails {
    /**
     * The name of the Cheese table.
     */
    public static final String TABLE_NAME = "place_detail";

    public static final String COLUMN_ID = BaseColumns._ID;
    public static final String PLACE_ID = "place_id";
    public static final String PLACE_NAME = "place_name";
    public static final String PLACE_ADDRESS = "place_address";

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true, name = COLUMN_ID)
    public long _id;

    @ColumnInfo(name = PLACE_NAME)
    public String place_name;


    @ColumnInfo(name = PLACE_ADDRESS)
    public String place_address;

    @ColumnInfo(name = PLACE_ID)
    public String place_id;
}
