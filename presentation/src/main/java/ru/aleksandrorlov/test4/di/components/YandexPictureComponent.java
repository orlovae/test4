package ru.aleksandrorlov.test4.di.components;

import dagger.Component;
import ru.aleksandrorlov.test4.di.PerActivity;
import ru.aleksandrorlov.test4.di.modules.ActivityModule;
import ru.aleksandrorlov.test4.di.modules.ApplicationModule;
import ru.aleksandrorlov.test4.di.modules.YandexPictureModule;
import ru.aleksandrorlov.test4.view.activity.MainActivity;

/**
 * Created by alex on 18.03.18.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class,
        YandexPictureModule.class})
public interface YandexPictureComponent extends ActivityComponent {
    void inject(MainActivity mainActivity);
//    void inject(UserDetailsFragment userDetailsFragment);
}
