package ru.aleksandrorlov.data.database;

import java.util.Collection;
import java.util.List;

import io.reactivex.Observable;
import ru.aleksandrorlov.data.entity.YandexPictureEntity;

/**
 * Created by alex on 16.03.18.
 */

public interface YandexPictureDataBase {
    void put(YandexPictureEntity yandexPictureEntity);
    void putAll(Collection<YandexPictureEntity> yandexPictureEntityList);
    void update(final long yandexPictureId, YandexPictureEntity yandexPictureEntity);
    Observable<Boolean> delete(final long yandexPictureId);

    boolean contains(final long yandexPictureId);

    YandexPictureEntity getYandexPicture(final long yandexPictureId);
    List<YandexPictureEntity> getYandexPictureListAll();
}
