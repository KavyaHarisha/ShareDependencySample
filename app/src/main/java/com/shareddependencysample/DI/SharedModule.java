package com.shareddependencysample.DI;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lenovo on 07/02/2018.
 */
@Module
public class SharedModule {
    private Context mContext;

    public SharedModule(Context context){
        mContext = context;
    }

    @Singleton
    @Provides
    public Context provideContext(){
        return mContext;
    }

    @Singleton
    @Provides
    public SharedPreferences provideSharedReference(){
        return PreferenceManager.getDefaultSharedPreferences(mContext);
    }
}
