package ru.aleksandrorlov.data.repository.datasource;

import java.util.List;

import io.reactivex.Observable;
import ru.aleksandrorlov.data.entity.YandexPictureEntity;
import ru.aleksandrorlov.data.net.ParseNet;

/**
 * Created by alex on 16.03.18.
 */

public class CloudYandexPictureDataStore implements YandexPictureDataStore {
    private final ParseNet parseNet;

    public CloudYandexPictureDataStore(ParseNet parseNet) {
        this.parseNet = parseNet;
    }

    @Override
    public Observable<List<YandexPictureEntity>> yandexPictureEntityList() {
        return this.parseNet.yandexPictureEntityList();
    }

    @Override
    public Observable<YandexPictureEntity> yandexPictureEntity(long yandexPictureId) {
        return this.parseNet.yandexPictureEntity(yandexPictureId);
    }
}
