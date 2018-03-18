package ru.aleksandrorlov.test4.di.components;

import android.app.Activity;
import dagger.Component;
import ru.aleksandrorlov.test4.di.PerActivity;
import ru.aleksandrorlov.test4.di.modules.ActivityModule;

/**
 * Created by alex on 18.03.18.
 */

@PerActivity
@Component (dependencies = ApplicationComponent.class, modules = ActivityModule.class)
interface ActivityComponent {
    Activity activity();
}
