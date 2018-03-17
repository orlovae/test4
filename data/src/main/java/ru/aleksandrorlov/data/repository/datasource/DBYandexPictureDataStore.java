package ru.aleksandrorlov.data.repository.datasource;

import java.util.List;

import io.reactivex.Observable;
import ru.aleksandrorlov.data.database.YandexPictureDataBase;
import ru.aleksandrorlov.data.entity.YandexPictureEntity;

/**
 * Created by alex on 16.03.18.
 */

public class DBYandexPictureDataStore implements YandexPictureDataStore {
    private final YandexPictureDataBase yandexPictureDataBase;

    public DBYandexPictureDataStore(YandexPictureDataBase yandexPictureDataBase) {
        this.yandexPictureDataBase = yandexPictureDataBase;
    }

    @Override
    public Observable<List<YandexPictureEntity>> yandexPictureEntityList() {
        return Observable.fromArray(this.yandexPictureDataBase.getYandexPictureListAll());
    }

    @Override
    public Observable<YandexPictureEntity> yandexPictureEntity(long yandexPictureId) {
        return Observable.just(this.yandexPictureDataBase.getYandexPicture(yandexPictureId));
    }
}
