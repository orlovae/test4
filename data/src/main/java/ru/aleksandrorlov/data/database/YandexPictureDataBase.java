package ru.aleksandrorlov.data.database;

import java.util.List;

import ru.aleksandrorlov.data.entity.YandexPictureEntity;

/**
 * Created by alex on 16.03.18.
 */

public interface YandexPictureDataBase {
    void put(YandexPictureEntity yandexPictureEntity);
    void update(final int yandexPictureId, YandexPictureEntity yandexPictureEntity);
    void delete(final int yandexPictureId);

    YandexPictureEntity getYandexPicture(final int yandexPictureId);
    List<YandexPictureEntity> getYandexPictureList();
}
