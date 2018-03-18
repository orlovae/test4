package ru.aleksandrorlov.data.database;

import com.orm.SugarRecord;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import ru.aleksandrorlov.data.entity.YandexPictureEntity;

/**
 * Created by alex on 16.03.18.
 */

public class YandexPictureDataBaseImpl implements YandexPictureDataBase {

    @Inject
    public YandexPictureDataBaseImpl() {
    }

    @Override
    public void put(YandexPictureEntity yandexPictureEntity) {
        yandexPictureEntity.save();
    }

    @Override
    public void putAll(Collection<YandexPictureEntity> yandexPictureEntityList) {
        SugarRecord.saveInTx(yandexPictureEntityList);
    }

    @Override
    public void update(long yandexPictureId, YandexPictureEntity newEntity) {
        YandexPictureEntity oldEntity =
                YandexPictureEntity.findById(YandexPictureEntity.class, yandexPictureId);
        oldEntity.setUrl(newEntity.getUrl());
        oldEntity.setRequest(newEntity.getRequest());
        oldEntity.save();
    }

    @Override
    public void delete(long yandexPictureId) {
        YandexPictureEntity yandexPictureEntity =
                YandexPictureEntity.findById(YandexPictureEntity.class, yandexPictureId);
        yandexPictureEntity.delete();
    }

    @Override
    public boolean contains(long yandexPictureId) {
        return getYandexPicture(yandexPictureId) != null ? true : false;
    }

    @Override
    public YandexPictureEntity getYandexPicture(long yandexPictureId) {
        return YandexPictureEntity.findById(YandexPictureEntity.class, yandexPictureId);
    }

    @Override
    public List<YandexPictureEntity> getYandexPictureListAll() {
        return YandexPictureEntity.listAll(YandexPictureEntity.class);
    }
}
