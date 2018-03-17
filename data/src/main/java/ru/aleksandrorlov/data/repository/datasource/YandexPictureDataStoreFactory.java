package ru.aleksandrorlov.data.repository.datasource;

import javax.inject.Singleton;

import ru.aleksandrorlov.data.database.YandexPictureDataBase;

/**
 * Created by alex on 16.03.18.
 */
@Singleton
public class YandexPictureDataStoreFactory {

    private final YandexPictureDataBase yandexPictureDataBase;

    public YandexPictureDataStoreFactory(YandexPictureDataBase yandexPictureDataBase) {
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
        return null;
    }
}
