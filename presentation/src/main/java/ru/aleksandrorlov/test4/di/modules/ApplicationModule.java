package ru.aleksandrorlov.test4.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.aleksandrorlov.data.database.YandexPictureDataBase;
import ru.aleksandrorlov.data.database.YandexPictureDataBaseImpl;
import ru.aleksandrorlov.data.executor.JobExecutor;
import ru.aleksandrorlov.data.repository.YandexPictureDataRepository;
import ru.aleksandrorlov.domain.executor.PostExecutionThread;
import ru.aleksandrorlov.domain.executor.ThreadExecutor;
import ru.aleksandrorlov.domain.repository.YandexPictureRepository;
import ru.aleksandrorlov.test4.AndroidApplication;
import ru.aleksandrorlov.test4.UIThread;

/**
 * Created by alex on 18.03.18.
 */

@Module
public class ApplicationModule {
    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    YandexPictureDataBase provideyandexPictureDataBase(YandexPictureDataBaseImpl yandexPictureDataBase) {
        return yandexPictureDataBase;
    }

    @Provides
    @Singleton
    YandexPictureRepository provideYandexPictureRepository(YandexPictureDataRepository yandexPictureDataRepository) {
        return yandexPictureDataRepository;
    }
}
