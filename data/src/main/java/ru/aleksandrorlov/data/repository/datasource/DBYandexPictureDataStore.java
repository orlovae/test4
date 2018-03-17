package ru.aleksandrorlov.data.repository.datasource;

import java.util.List;

import io.reactivex.Observable;
import ru.aleksandrorlov.data.database.YandexPictureDataBase;
import ru.aleksandrorlov.data.entity.YandexPictureEntity;

/**
 * Created by alex on 16.03.18.
 */

public class DBYandexPictureDataStore implements YandexPictureDataStore {
    private final YandexPictureDataBase dataBase;

    public DBYandexPictureDataStore(YandexPictureDataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public Observable<List<YandexPictureEntity>> yandexPictureEntityList() {
        return Observable.fromArray(this.dataBase.getYandexPictureListAll());
    }

    @Override
    public Observable<YandexPictureEntity> yandexPictureEntity(long yandexPictureId) {
        return Observable.just(this.dataBase.getYandexPicture(yandexPictureId));
    }
}
