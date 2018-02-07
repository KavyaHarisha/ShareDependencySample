package com.shareddependencysample.DI;

import com.shareddependencysample.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by lenovo on 07/02/2018.
 */
@Singleton
@Component(modules = SharedModule.class)
public interface ShareComponent {
    void inject(MainActivity mActivity);
}
