package ru.aleksandrorlov.data.repository.datasource;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import ru.aleksandrorlov.data.database.YandexPictureDataBase;
import ru.aleksandrorlov.data.net.ParseNet;
import ru.aleksandrorlov.data.net.ParseNetImpl;

/**
 * Created by alex on 16.03.18.
 */
@Singleton
public class YandexPictureDataStoreFactory {
    private final Context context;
    private final YandexPictureDataBase yandexPictureDataBase;

    @Inject
    public YandexPictureDataStoreFactory(Context context,
                                         YandexPictureDataBase yandexPictureDataBase) {
        this.context = context.getApplicationContext();
        this.yandexPictureDataBase = yandexPictureDataBase;
    }
    public YandexPictureDataStore create(long yandexPictureId) {
        YandexPictureDataStore yandexPictureDataStore;

        if (this.yandexPictureDataBase.contains(yandexPictureId)) {
            yandexPictureDataStore = new DBYandexPictureDataStore(yandexPictureDataBase);
        } else {
            yandexPictureDataStore = createCloudYandexPictureDataStore();
        }
        return yandexPictureDataStore;
    }

    public YandexPictureDataStore createCloudYandexPictureDataStore() {
        final ParseNet parseNet = new ParseNetImpl(context);
        return new CloudYandexPictureDataStore(parseNet);
    }
}
