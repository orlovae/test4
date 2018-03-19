package ru.aleksandrorlov.test4.di.modules;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import ru.aleksandrorlov.test4.di.PerActivity;

/**
 * Created by alex on 18.03.18.
 */

@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity activity() {
        return this.activity;
    }
}
