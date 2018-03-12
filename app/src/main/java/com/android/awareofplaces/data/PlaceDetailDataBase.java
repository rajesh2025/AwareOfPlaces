package com.android.awareofplaces.data;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.android.awareofplaces.R;

/**
 * Created by user on 28-02-2018.
 */
@Database(entities = {PlaceDetails.class}, version = 1)
public abstract class PlaceDetailDataBase extends RoomDatabase {
    @SuppressWarnings("WeakerAccess")
    public abstract PlaceDetailsDao placeDetails();

    private static PlaceDetailDataBase mInstance;

    public static  PlaceDetailDataBase getInstance(Context context){
        if(mInstance == null){
            synchronized (PlaceDetailDataBase.class){
                mInstance = Room
                        .databaseBuilder(context.getApplicationContext(), PlaceDetailDataBase.class,context.getString(R.string.app_name))
                        .build();
            }
        }
        return mInstance;
    }
}


