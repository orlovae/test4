package ru.aleksandrorlov.data.repository.datasource;

import ru.aleksandrorlov.data.database.YandexPictureDataBase;

/**
 * Created by alex on 16.03.18.
 */
@Singleton
public class YandexPictureDataStoreFactory {

    private final YandexPictureDataBase dataBase;

    public YandexPictureDataStoreFactory(YandexPictureDataBase dataBase) {
        this.dataBase = dataBase;
    }
    public YandexPictureDataStore create(long yandexPictureId) {
        YandexPictureDataStore yandexPictureDataStore;

        if (this.dataBase.contains(yandexPictureId)) {
            yandexPictureDataStore = new DBYandexPictureDataStore(dataBase);
        } else {
            yandexPictureDataStore = createCloudYandexPictureDataStore();
        }
        return yandexPictureDataStore;
    }

    public YandexPictureDataStore createCloudYandexPictureDataStore() {
        return null;
    }
}
