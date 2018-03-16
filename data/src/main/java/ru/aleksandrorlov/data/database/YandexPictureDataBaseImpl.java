package ru.aleksandrorlov.data.database;

import java.util.List;

import ru.aleksandrorlov.data.entity.YandexPictureEntity;

/**
 * Created by alex on 16.03.18.
 */

public class YandexPictureDataBaseImpl implements YandexPictureDataBase {


    @Override
    public void put(YandexPictureEntity yandexPictureEntity) {

    }

    @Override
    public void update(long yandexPictureId, YandexPictureEntity yandexPictureEntity) {

    }

    @Override
    public void delete(long yandexPictureId) {

    }

    @Override
    public YandexPictureEntity getYandexPicture(long yandexPictureId) {
        return YandexPictureEntity.findById(YandexPictureEntity.class, yandexPictureId);
    }

    @Override
    public List<YandexPictureEntity> getYandexPictureList() {
        return YandexPictureEntity.listAll(YandexPictureEntity.class);
    }
}
