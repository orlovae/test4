package ru.aleksandrorlov.data.repository.datasource;

import java.util.List;

import io.reactivex.Observable;
import ru.aleksandrorlov.data.entity.YandexPictureEntity;

/**
 * Created by alex on 16.03.18.
 */

public class DBYandexPictureDataStore implements YandexPictureDataStore {
    @Override
    public Observable<List<YandexPictureEntity>> yandexPictureEntityList() {
        return null;
    }

    @Override
    public Observable<YandexPictureEntity> yandexPictureEntity(int yandexPictureId) {
        return null;
    }
}
