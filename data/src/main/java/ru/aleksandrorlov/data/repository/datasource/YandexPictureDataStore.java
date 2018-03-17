package ru.aleksandrorlov.data.repository.datasource;

import java.util.List;

import io.reactivex.Observable;
import ru.aleksandrorlov.data.entity.YandexPictureEntity;

/**
 * Created by alex on 16.03.18.
 */

public interface YandexPictureDataStore {
    Observable<List<YandexPictureEntity>> yandexPictureEntityList();

    Observable<YandexPictureEntity> yandexPictureEntity(final long yandexPictureId);
}
