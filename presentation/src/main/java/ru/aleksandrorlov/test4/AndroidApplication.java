package ru.aleksandrorlov.test4;

import android.app.Application;

import ru.aleksandrorlov.test4.di.components.ApplicationComponent;
import ru.aleksandrorlov.test4.di.components.DaggerApplicationComponent;
import ru.aleksandrorlov.test4.di.modules.ApplicationModule;

/**
 * Created by alex on 18.03.18.
 */

public class AndroidApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}
