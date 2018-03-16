package ru.aleksandrorlov.data.database;

import java.util.Collection;
import java.util.List;

import ru.aleksandrorlov.data.entity.YandexPictureEntity;

/**
 * Created by alex on 16.03.18.
 */

public interface YandexPictureDataBase {
    void put(YandexPictureEntity yandexPictureEntity);
    void putAll(Collection<YandexPictureEntity> yandexPictureEntityList);
    void update(final long yandexPictureId, YandexPictureEntity yandexPictureEntity);
    void delete(final long yandexPictureId);

    YandexPictureEntity getYandexPicture(final long yandexPictureId);
    List<YandexPictureEntity> getYandexPictureList();
}
