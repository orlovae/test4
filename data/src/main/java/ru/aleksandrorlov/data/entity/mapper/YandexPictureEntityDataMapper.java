package ru.aleksandrorlov.data.entity.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import ru.aleksandrorlov.data.entity.YandexPictureEntity;
import ru.aleksandrorlov.domain.YandexPicture;

/**
 * Created by alex on 16.03.18.
 */

@Singleton
public class YandexPictureEntityDataMapper {

    @Inject
    YandexPictureEntityDataMapper() {}

    public YandexPicture transform(YandexPictureEntity yandexPictureEntity) {
        YandexPicture yandexPicture = null;
        if (yandexPictureEntity != null) {
            yandexPicture = new YandexPicture(yandexPictureEntity.getYandexPictureId());
            yandexPicture.setUrl(yandexPictureEntity.getUrl());
            yandexPicture.setRequest(yandexPictureEntity.getRequest());
        }
        return yandexPicture;
    }

    public List<YandexPicture> transform(Collection<YandexPictureEntity> yandexPictureEntityCollection) {
        final List<YandexPicture> yandexPictureList = new ArrayList<>(20);
        for (YandexPictureEntity yandexPictureEntity : yandexPictureEntityCollection) {
            final YandexPicture yandexPicture = transform(yandexPictureEntity);
            if (yandexPicture != null) {
                yandexPictureList.add(yandexPicture);
            }
        }
        return yandexPictureList;
    }
}
