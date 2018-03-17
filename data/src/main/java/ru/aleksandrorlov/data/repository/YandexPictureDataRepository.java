package ru.aleksandrorlov.data.repository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import ru.aleksandrorlov.data.entity.mapper.YandexPictureEntityDataMapper;
import ru.aleksandrorlov.data.repository.datasource.YandexPictureDataStore;
import ru.aleksandrorlov.data.repository.datasource.YandexPictureDataStoreFactory;
import ru.aleksandrorlov.domain.YandexPicture;
import ru.aleksandrorlov.domain.repository.YandexPictureRepository;

/**
 * Created by alex on 16.03.18.
 */

@Singleton
public class YandexPictureDataRepository implements YandexPictureRepository {
    private final YandexPictureDataStoreFactory yandexPictureDataStoreFactory;
    private final YandexPictureEntityDataMapper yandexPictureEntityDataMapper;

    @Inject
    public YandexPictureDataRepository(YandexPictureDataStoreFactory yandexPictureDataStoreFactory,
                                       YandexPictureEntityDataMapper yandexPictureEntityDataMapper) {
        this.yandexPictureDataStoreFactory = yandexPictureDataStoreFactory;
        this.yandexPictureEntityDataMapper = yandexPictureEntityDataMapper;
    }

    @Override
    public Observable<List<YandexPicture>> yandexPictures() {
        final YandexPictureDataStore dataStore =
                this.yandexPictureDataStoreFactory.createCloudYandexPictureDataStore();
        return
                dataStore.yandexPictureEntityList().map(this.yandexPictureEntityDataMapper::transform);
    }

    @Override
    public Observable<YandexPicture> yandexPicture(long yandexPictureId) {
        final YandexPictureDataStore dataStore =
                this.yandexPictureDataStoreFactory.create(yandexPictureId);
        return
                dataStore.yandexPictureEntity(yandexPictureId).map(this.yandexPictureEntityDataMapper::transform);
    }
}
