package ru.aleksandrorlov.test4.di.components;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import ru.aleksandrorlov.domain.executor.PostExecutionThread;
import ru.aleksandrorlov.domain.executor.ThreadExecutor;
import ru.aleksandrorlov.domain.repository.YandexPictureRepository;
import ru.aleksandrorlov.test4.di.modules.ApplicationModule;
import ru.aleksandrorlov.test4.view.activity.MainActivity;

/**
 * Created by alex on 18.03.18.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void injectMainActivity(MainActivity mainActivity);

    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();
    YandexPictureRepository yandexPictureRepository();
}
